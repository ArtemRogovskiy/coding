package stepik.csc.kotlin

fun main() {
    val b = null.toString()
    println(b)
    val input = "82 null null null null null 7 55 null 59 4 25 null null 66 null 3 62 55 null 42 5 35 8 null"
//    calcNullValues(input.split(" ").map { it?.toInt() })
}

fun calcNullValues(input: Array<Int?>):Array<Int>{

    val (a, b) = input.partition { it == null }

    return arrayOf(a.size, b.sumBy { it!!.toInt() })
}