rootProject.buildFileName = "build.gradle.kts"

include(
    ModuleDependency.APP,
    ModuleDependency.FEATURE_BASE,
    ModuleDependency.FEATURE_ALBUM,
    ModuleDependency.LIBRARY_TEST_UTILS
)
