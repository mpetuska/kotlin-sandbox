plugins {
  id("convention.kjs")
}

kotlin {
  js {
    useCommonJs()
//    browser { testTask { useKarma() } }
    nodejs()
    binaries.executable()
  }
  sourceSets {
    named("main") {
      dependencies {
        implementation(npm("cdktf", "^0.15.5"))
        implementation(npm("constructs", "^10.1.255"))
      }
    }
    named("test") {
      dependencies {
        implementation(kotlin("test-js"))
      }
    }
  }
}
