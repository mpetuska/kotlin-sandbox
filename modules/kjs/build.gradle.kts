plugins {
  id("convention.kjs")
}

kotlin {
  js {
    useCommonJs()
    browser { testTask { useKarma() } }
//    nodejs()
    binaries.executable()
  }
  sourceSets {
    named("main") {
      dependencies {
        implementation(npm("@midzer/tobii", "2.5.0"))
      }
    }
    named("test") {
      dependencies {
        implementation(kotlin("test-js"))
      }
    }
  }
}
