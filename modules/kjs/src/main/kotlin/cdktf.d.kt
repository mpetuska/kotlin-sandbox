@file:JsModule("cdktf")
@file:Suppress("UnusedPrivateMember")

package kjs

external interface AppConfig {
  val outdir: String? get() = definedExternally
  val stackTraces: Boolean? get() = definedExternally
  val context: dynamic get() = definedExternally
  val skipValidation: Boolean? get() = definedExternally
}

open external class App(config: AppConfig = definedExternally) : Construct {
  fun synth()
}

open external class TerraformStack(scope: Construct, id: String) : Construct

external interface TerraformVariableValidationConfig {
  val condition: /* Expression */ dynamic
  val errorMessage: String
}

external interface TerraformVariableConfig {
  val default: Any? get() = definedExternally
  val description: String? get() = definedExternally
  val type: String? get() = definedExternally
  val sensitive: Boolean? get() = definedExternally
  val nullable: Boolean? get() = definedExternally
  val validation: Array<TerraformVariableValidationConfig>? get() = definedExternally
}

external class TerraformVariable(scope: Construct, id: String, config: TerraformVariableConfig)
