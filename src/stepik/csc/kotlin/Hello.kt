package stepik.csc.kotlin


fun main() {
    println(start());
}

// Task 1.13
fun getList(): List<Int> {
    return arrayListOf(1, 5, 2).sortedDescending()
}

// Task 1.11

//fun getList(): List<Int> {
//    val arrayList = arrayListOf(1, 5, 2)
//    Collections.sort(arrayList) { a, b -> b - a }
//    return arrayList
//}

// Task 1.10
fun Int.r(): RationalNumber = RationalNumber(this)

fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(this.first, this.second)

data class RationalNumber(val numerator: Int, val denominator: Int = 1)

// Task 1.9
fun eval(expr: Expr): Int =
        when (expr) {
            is Num -> expr.value
            is Sum -> eval(expr.left) + eval(expr.right)
            else -> throw IllegalArgumentException("Unknown expression")
        }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

// Task 1.8
fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    message ?: return
    val personalInfo = client?.personalInfo ?: return
    val email = personalInfo.email ?: return
    mailer.sendMessage(email, message)
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}


// Task 1.7
class Person(val name: String, val age: Int)

// Task 1.6
val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern() = """\d{2} $month \d{4}"""

// Task 1.5
fun containsEven(collection: Collection<Int>): Boolean = collection.any { a -> a % 2 == 0 }

// Task 1.4
fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
        (if (toUpperCase) name.toUpperCase() else name) + number

fun useFoo() = listOf(
        foo("a"),
        foo("b", number = 1),
        foo("c", toUpperCase = true),
        foo(name = "d", number = 2, toUpperCase = true)
)

// Task 1.2
fun toJSON(collection: Collection<Int?>): String {
    val sb = StringBuilder()
    sb.append("[")
    val iterator = collection.iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()
        sb.append(element)
        if (iterator.hasNext()) {
            sb.append(", ")
        }
    }
    sb.append("]")
    return sb.toString()
}

// Task 1.1
fun start() = "OK"

fun getYearEra(year: Int): String {
    return when {
        year == 1970 -> "equals"
        year in 1971..1999 -> "after (XX century)"
        year in 2000..2099 -> "after (XXI century)"
        year >= 2100 -> "distant future"
        year < 1970 -> "before"
        else -> "Error"
    }
}

fun calculateEvenDigits(input: String) = input.toCharArray().map(Char::toString).map(String::toInt).filter { e -> e % 2 == 0 }.sum()

fun calculateBugMentions(input: List<String>) = input.filter { it == "BUG" }.count()

open class A(var a: Int) {
    open fun magic() = a
}

open class B(b: Int) : A(b) {
    override fun magic(): Int {
        return super.magic()
    }
}

class C : B(2) {
    override fun magic(): Int {
        return 3
    }
}

fun calculateWordStat(input: String): String {
    val mutableMap: MutableMap<String, Int> = HashMap<String, Int>()
    for (str in input.split(" ")) {
        mutableMap[str] = mutableMap.getOrDefault(str, 0) + 1
    }
    var max = 0
    var res = ""
    for ((k, v) in mutableMap) {
        if (v > max) {
            max = v
            res = k
        }
    }
    return res
}

val a:String? = null;

var b = a?.length.toString() + "str"