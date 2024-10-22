package kotli.app.feature.showcases.presentation.dataflow.http.basic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.delay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import shared.data.misc.isCancellationException
import shared.data.source.http.HttpSource
import shared.data.source.http.isHttpTimeoutException
import shared.presentation.viewmodel.BaseViewModel

class BasicHttpViewModel(
    private val httpSource: HttpSource
) : BaseViewModel() {

    private val _state = BasicHttpMutableState()
    val state: BasicHttpState = _state

    fun onFetchIp() = async("Fetch IP") {
        try {
            _state.ip = "Start fetching…"
            delay(500)
            _state.ip = "Delay fetching…"
            delay(500)
            _state.ip = "Proceed fetching…"
            val url = "https://api64.ipify.org?format=json"
            val ipData = httpSource.client.get(url).body<IpData>()
            _state.ip = ipData.ip
        } catch (e: Throwable) {
            if (!e.isCancellationException() && !e.isHttpTimeoutException()) {
                _state.ip =
                    """
Error (see system console):
${e.message.orEmpty()}
${e.stackTraceToString()}
                        """.trimIndent()
            }
        }
    }

    @Serializable
    private data class IpData(
        @SerialName("ip")
        val ip: String
    )

    private class BasicHttpMutableState : BasicHttpState {
        override var ip: String by mutableStateOf("")
    }

}
