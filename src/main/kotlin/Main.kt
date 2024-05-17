import java.math.BigDecimal

fun main(args: Array<String>) {
    println("hello")
}

fun a(str: String?) {
    val a: BigDecimal = BigDecimal("55")
    val split = a.toString().split(".")
    val l = split[1].length
    print(l)
}