package stepik.csc.kotlin
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {
    val test = Test();
    test.v
    test.v
    test.v
}

// Task 4.4
class D {
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

    var timeInMillis: MyDate? = null

    override fun getValue(thisRef: R, property: KProperty<*>) = timeInMillis!!

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        timeInMillis = value
    }
}

// Task 4.2
class LazyProperty(val initializer: () -> Int) {
    private var lazyVar: Int? = null
    val lazy: Int
        get() {
            if (lazyVar == null) {
                lazyVar = initializer()
            }
            return lazyVar!!
        }
}


// Task 4.1
class PropertyExample() {
    var counter = 0
    var propertyWithCounter: Int? = null
        set(value) {
            ++counter
            field = value
        }
}

class Test() {
    val v = 1
        get() {
            ++count
            println(count)
            return field
        }
    var count = 0


}