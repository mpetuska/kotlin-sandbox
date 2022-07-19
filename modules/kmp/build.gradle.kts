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
  linuxX64 {
    compilations["main"].apply {
      cinterops {
        create("gtk4")
        create("adw")
      }
    }
    binaries {
      executable {
        entryPoint = "kmp.main"
      }
    }
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
