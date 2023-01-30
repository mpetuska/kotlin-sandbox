import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
  mavenCentral()
  google()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
  implementation("org.jetbrains.kotlin:kotlin-serialization:_")
  implementation("com.github.jakemarsden:git-hooks-gradle-plugin:_")
  implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:_")
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}

tasks {
  withType<KotlinCompile> {
    kotlinOptions {
      languageVersion = "1.8"
    }
  }
}
