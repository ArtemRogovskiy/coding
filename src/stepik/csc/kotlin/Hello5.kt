package stepik.csc.kotlin

import java.util.*

fun main() {

}
// Task 5.4

fun renderProductTable(): String {
    return html {
        table {
            tr(getTitleColor()) {
                td(getCellColor(0, 0)) {
                    text("Product")
                }
                td(getCellColor(0, 1)) {
                    text("Price")
                }
                td(getCellColor(0, 2)) {
                    text("Popularity")
                }
            }
            val products = getProducts()
            for (i in products.indices) {
                tr {
                    td(getCellColor(i + 1, 0)) {
//                        text(products[i].description)
                    }
                    td(getCellColor(i + 1, 1)) {
                        text(products[i].price)
                    }
                    td(getCellColor(i + 1, 2)) {
//                        text(products[i].popularity)
                    }
                }
            }
        }
    }.toString()
}
//data class Product(val description: String, val price: Double, val popularity: Int)
open class Tag(val name: String)
class Attribute(val name: String, val value: String)
class Html : Tag("html")
class Table : Tag("table")
class Center : Tag("center")
class TR : Tag("tr")
class TD : Tag("td")
class Text(val text: String) : Tag("b")

fun html(init: Html.() -> Unit): Html = TODO()
fun Html.table(init: Table.() -> Unit): Table = TODO()
fun Table.tr(color: String? = null, init: TR.() -> Unit): TR = TODO()
fun TR.td(color: String? = null, align: String = "left", init: TD.() -> Unit): TD = TODO()
fun Tag.text(s: Any?): Text = TODO()
fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) % 2 == 0) "#dce4ff" else "#eff2ff"
fun getProducts(): List<Product> = TODO()


// Task 5.3
fun <T> T.myApply(f: T.() -> Unit) = apply(f)

fun createString(): String {
    return StringBuilder().myApply {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

fun createMap(): Map<Int, String> {
    return hashMapOf<Int, String>().myApply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}


// Task 5.2
fun buildMap(build: HashMap<Int, String>.() -> Unit): Map<Int, String> {
    val map = HashMap<Int, String>()
    map.build()
    return map
}

fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

// Task 5.1
fun task(): List<Boolean> {
    val isEven: Int.() -> Boolean = { this % 2 == 0 }
    val isOdd: Int.() -> Boolean = { !this.isEven() }

    return listOf(42.isOdd(), 239.isOdd(), 294823098.isEven())
}