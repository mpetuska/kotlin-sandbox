package kjvm

fun main(vararg args: String) {
  println(args.toList())
  listOf(1, 2, 3).let(::println)
}
