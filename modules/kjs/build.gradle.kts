plugins {
  id("convention.kjs")
}

kotlin {
  js {
    useCommonJs()
    browser {
      testTask {
        useKarma()
      }
    }
    nodejs()
    binaries.library()
  }
  sourceSets {
    named("test") {
      dependencies {
        implementation(kotlin("test-js"))
      }
    }
  }
}
