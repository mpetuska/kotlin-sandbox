plugins {
  id("convention.kmp")
}

kotlin {
  jvm()
  js {
    useCommonJs()
    browser()
    nodejs()
  }
  sourceSets {
    named("commonTest") {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
      }
    }
    named("jsTest") {
      dependencies {
        implementation(kotlin("test-js"))
      }
    }
    named("jvmTest") {
      dependencies {
        implementation(kotlin("test-junit5"))
      }
    }
  }
}
