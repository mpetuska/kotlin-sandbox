@file:Suppress("UnusedPrivateMember")
@file:JsModule("@midzer/tobii")

package kjs

@JsName("default")
external class Tobii(userOpts: TobiiUserOpts)

sealed external interface TobiiUserOpts {
  var autoplayVideo: Boolean?
}
