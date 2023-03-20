package kjs

fun main() {
  val res = Tobii(
    js("{}").unsafeCast<TobiiUserOpts>().apply {
      autoplayVideo = true
    }
  )
  console.log(res)
}
