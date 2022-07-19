plugins {
  id("convention.kjs")
}

kotlin {
  js {
    useCommonJs()
    browser()
    nodejs()
  }
  sourceSets {
    named("test") {
      dependencies {
        implementation(kotlin("test-js"))
      }
    }
  }
}
