plugins {
  id("de.fayard.refreshVersions") version "0.60.0"
  id("com.gradle.enterprise") version "3.12.3"
}

refreshVersions {
  versionsPropertiesFile = rootDir.resolve("gradle/versions.properties")
  extraArtifactVersionKeyRules(rootDir.resolve("gradle/versions.rules"))
}

rootProject.name = "kotlin-sandbox"

includeBuild("./build-conventions")

include(
  ":modules:kjs",
  ":modules:kjvm",
  ":modules:kmp",
)
