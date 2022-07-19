# kotlin-sandbox

A clean and minimal setup for kotlin experiments.

## Structure

- [build-conventions](./build-conventions) - gradle logic and plugins
- [scripts](./scripts) - utility scripts to manage the project
- [gradle](./gradle) - gradle wrapper files as well as shared config files
  - [versions.properties](./gradle/versions.properties) - dependency versioning control
  - [detekt.yml](./gradle/detekt.yml) - detekt config
- [modules](./modules) - various sandboxes for kotlin code
  - [kjs](./modules/kjs) - kotlin/js sandbox
  - [kjvm](./modules/kjvm) - kotlin/jvm sandbox
  - [kmp](./modules/kmp) - kotlin/multiplatform sandbox
