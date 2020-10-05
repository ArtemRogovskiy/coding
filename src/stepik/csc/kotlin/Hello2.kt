package stepik.csc.kotlin

fun main() {

}
// Task 2.4
class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator() = object : Iterator<MyDate> {
        var current = start;

        override fun hasNext() = current <= end

        override fun next(): MyDate {
            val tmp = current;
//            current = current.nextDay()
            return tmp;
        }
    }
}

//class DateRangeIterator(val start: MyDate, val end: MyDate) : Iterator<MyDate> {
//    var current = start;
//
//    override fun hasNext(): Boolean {
//        return current <= end;
//    }
//
//    override fun next(): MyDate {
//        val tmp = current;
//        current = current.nextDay()
//        return tmp;
//    }
//
//}
//
//class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
//    override fun iterator() = DateRangeIterator(start, end)
//
//}
operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}


// Task 2.2
//class DateRange(val start: MyDate, val endInclusive: MyDate) {
//    operator fun contains(date: MyDate): Boolean {
//        return start < date && date <= endInclusive
//    }
//}
//
//fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
//    return date in DateRange(first, last)
//}


// Task 2.1
data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return (year - other.year) * 372 + (month - other.month) * 31 + dayOfMonth - other.dayOfMonth
    }

}

fun compare(date1: MyDate, date2: MyDate) = date1 < date2