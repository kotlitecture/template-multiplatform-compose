package kotli.app.common.data.source.config

import shared.data.source.config.DelegateConfigSource

/**
 * This class represents a configuration source for application settings.
 * It delegates to an underlining source and provides methods to retrieve various configuration values
 * without keys passed.
 */
class AppConfigSource : DelegateConfigSource(
    // delegate
)