package kotli.app.feature.passcode.domain.usecase

import kotli.app.feature.passcode.domain.repository.PasscodeRepository
import shared.data.source.settings.SettingsSource

class ForgotPasscodeUseCase(
    private val repository: PasscodeRepository,
    private val settingsSource: SettingsSource,
) {

    suspend fun invoke() {
        settingsSource.clear()
        repository.reset()
    }

}