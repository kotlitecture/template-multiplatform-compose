package kotli.template.multiplatform.compose

import kotli.engine.model.FeatureTags

object Tags {

    val All = listOf(
        FeatureTags.Android,
        FeatureTags.IOS,
        FeatureTags.Web,
        FeatureTags.Desktop,
        FeatureTags.Server,
    )

    val AllClients = listOf(
        FeatureTags.Android,
        FeatureTags.IOS,
        FeatureTags.Web,
        FeatureTags.Desktop,
    )

    val Mobile = listOf(
        FeatureTags.Android,
        FeatureTags.IOS
    )

    val MobileAndDesktop = listOf(
        FeatureTags.Android,
        FeatureTags.IOS,
        FeatureTags.Desktop,
    )

    val WebAndDesktop = listOf(
        FeatureTags.Desktop,
    )

}