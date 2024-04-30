@file:OptIn(ExperimentalPathApi::class)

package kotli.template.multiplafrom.compose

import kotli.engine.DefaultTemplateRegistry
import kotli.engine.generator.GradleProjectGenerator
import kotli.engine.generator.PathOutputGenerator
import kotli.engine.generator.ZipOutputGenerator
import kotli.engine.model.Feature
import kotli.engine.model.Layer
import kotli.template.multiplatform.compose.MultiplatformComposeTemplateProcessor
import kotli.template.multiplatform.compose.platform.PlatformProcessor
import kotli.template.multiplatform.compose.platform.android.AndroidPlatformProcessor
import kotli.template.multiplatform.compose.platform.jvm.JvmPlatformProcessor
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.slf4j.LoggerFactory
import java.io.ByteArrayOutputStream
import java.io.File
import java.nio.file.Path
import java.util.Random
import java.util.UUID
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.deleteRecursively
import kotlin.test.Test

class MultiplatformComposeTemplateProcessorTest {

    private val logger = LoggerFactory.getLogger(this::class.java)

    private val processor = MultiplatformComposeTemplateProcessor
    private val registry = DefaultTemplateRegistry(processor)

    private val testCommands = arrayOf("signingReport", "assembleDebug")
//    private val testCommands = arrayOf("run")

    private fun buildPath(): Path {
        return File("build/template").toPath().toAbsolutePath().also { it.deleteRecursively() }
    }

    @Test
    fun `icon, title and description exist`() {
        Assertions.assertNotNull(processor.getIcon())
        Assertions.assertNotNull(processor.getTitle())
        Assertions.assertNotNull(processor.getDescription())
    }

    @Test
    fun `features have title and description`() {
        processor.getFeatureProviders()
            .filter { provider -> provider.getProcessors().any { !it.isInternal() } }
            .forEach { provider ->
                Assertions.assertNotNull(processor.getTitle())
                provider.getProcessors()
                    .filter { !it.isInternal() }
                    .forEach { processor ->
                        Assertions.assertNotNull(processor.getTitle())
                        Assertions.assertNotNull(processor.getDescription())
                    }
            }
    }

    @Test
    fun `feature providers are unique`() {
        val providers = processor.getFeatureProviders()
        val notUnique = providers.groupBy { it.getId() }.filter { it.value.size > 1 }
        notUnique.forEach { group ->
            Assertions.fail(group.value.toString())
        }
    }

    @Test
    fun `feature processors are unique`() {
        val processors = processor.getFeatureProviders().map { it.getProcessors() }.flatten()
        val notUnique = processors.groupBy { it.getId() }.filter { it.value.size > 1 }
        notUnique.forEach { group ->
            Assertions.fail(group.value.toString())
        }
    }

    @Test
    fun `compose template in memory`() {
        runBlocking {
            val output = ByteArrayOutputStream()
            val layer = Layer(
                id = UUID.randomUUID().toString(),
                processorId = processor.getId(),
                namespace = "my.app",
                name = "myApp",
            )
            val generator = PathOutputGenerator(registry = registry)
            val zipGenerator = ZipOutputGenerator(output, generator)
            zipGenerator.generate(layer)
            Assertions.assertTrue(output.size() > 50000)
        }
    }

    @Test
    fun `compose template without features`() {
        runBlocking {
            val layer = Layer(
                id = UUID.randomUUID().toString(),
                processorId = processor.getId(),
                namespace = "my.app",
                name = "myApp",
                features = listOf(
                    Feature(AndroidPlatformProcessor.ID)
                )
            )
            val generator = PathOutputGenerator(buildPath(), registry)
            val gradleGenerator = GradleProjectGenerator(testCommands, generator)
            gradleGenerator.generate(layer)
        }
    }

    @Test
    fun `compose template with all features`() {
        runBlocking {
            val layer = Layer(
                id = UUID.randomUUID().toString(),
                processorId = processor.getId(),
                namespace = "my.app",
                name = "myApp",
            )
            val generator = PathOutputGenerator(buildPath(), registry, fat = true)
            val gradleGenerator = GradleProjectGenerator(testCommands, generator)
            gradleGenerator.generate(layer)
        }
    }

    @Test
    fun `compose template with random features`() {
        runBlocking {
            val processors = processor.getFeatureProviders()
                .map { it.getProcessors() }
                .flatten()
                .filter { !it.isInternal() }
            val features = mutableSetOf<Feature>()
            repeat(Random().nextInt(1, processors.size + 1)) {
                features.add(Feature(processors.random().getId()))
            }
            logger.debug("features :: {} -> {}", features.size, features.map { it.id })
            val layer = Layer(
                id = UUID.randomUUID().toString(),
                processorId = processor.getId(),
                features = features.toList(),
                namespace = "my.app",
                name = "myApp",
            )
            val generator = PathOutputGenerator(buildPath(), registry)
            val gradleGenerator = GradleProjectGenerator(testCommands, generator)
            gradleGenerator.generate(layer)
        }
    }

}