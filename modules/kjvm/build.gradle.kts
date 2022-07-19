plugins {
  id("convention.kjvm")
}

kotlin {
  sourceSets {
    named("test") {
      dependencies {
        implementation(kotlin("test-junit5"))
      }
    }
  }
}
