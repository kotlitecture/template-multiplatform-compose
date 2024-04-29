package app.showcases.datasource.http.basic

import shared.data.datasource.http.HttpSource
import shared.data.misc.extensions.isIgnoredException
import shared.core.BaseViewModel
import shared.core.navigation.NavigationState
import shared.core.state.StoreObject
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.delay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class BasicHttpViewModel(
    private val navigationState: NavigationState,
    private val httpSource: HttpSource
) : BaseViewModel() {

    val ipStore = StoreObject<String>()

    fun onBack() {
        navigationState.onBack()
    }

    fun onFetchIp() {
        launchAsync("onFetchIp") {
            try {
                ipStore.set("Start fetching…")
                delay(500)
                ipStore.set("Delay fetching…")
                delay(500)
                ipStore.set("Proceed fetching…")
                val url = "https://api64.ipify.org?format=json"
                val ipData = httpSource.ktor.get(url).body<IpData>()
                ipStore.set(ipData.ip)
            } catch (e: Throwable) {
                if (!e.isIgnoredException()) {
                    ipStore.set(
                        """
Error (see system console):
${e.message.orEmpty()}
${e.stackTraceToString()}
                        """.trimIndent()
                    )
                }
            }
        }
    }

    @Serializable
    private data class IpData(
        @SerialName("ip")
        val ip: String
    )

}
