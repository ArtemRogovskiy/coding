package stepik.csc.kotlin

import java.util.*

fun <T, C : MutableCollection<in T>> Iterable<T>.partitionTo(collection: C, t: C, predicate: (T) -> Boolean): Pair<C, C> {
    val first = filter(predicate).toCollection(t)
    val second = filterNot(predicate).toCollection(collection)
    return Pair(first, second)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}


fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    letters == setOf('a', 'r')
    other == setOf('%', '}')
}