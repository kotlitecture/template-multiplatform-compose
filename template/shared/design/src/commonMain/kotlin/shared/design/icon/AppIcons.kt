package shared.design.icon

expect fun appIconsProvider(): AppIconsProvider

val AppIcons by lazy { appIconsProvider() }