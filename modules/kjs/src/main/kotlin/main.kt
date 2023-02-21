package kjs

class MyStack(scope: Construct, id: String) : TerraformStack(scope, id) {
  init {
    TerraformVariable(
      this,
      "my_var",
      object : TerraformVariableConfig {
        override val description = "Hey there"
      }
    )
  }
}

@Suppress("UnusedPrivateMember")
fun mkdirs(targetDir: String) {
  js("require('fs').mkdirSync(targetDir, { recursive: true });")
}

fun main() {
  runCatching(::test1).onFailure(console::error)
  runCatching(::test2).onFailure(console::error)
}

private fun test1() {
  val targetDir = "./dist/test1"
  mkdirs(targetDir)
  val app = App(object : AppConfig {
    override val outdir = targetDir
  })
  TerraformStack(app, "ctd-infra1")
  app.synth()
  console.log(">>> T1 DONE")
}

private fun test2() {
  val targetDir = "./dist/test2"
  mkdirs(targetDir)
  val app = App(object : AppConfig {
    override val outdir = targetDir
  })
  MyStack(app, "ctd-infra2")
  app.synth()
  console.log(">>> T2 DONE")
}
