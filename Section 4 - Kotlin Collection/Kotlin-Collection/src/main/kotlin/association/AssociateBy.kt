package association

import association.data.Book

fun main() {
    val books = listOf(
        Book("978-3-16-148410-0", "The Catcher in the Rye", "J.D. Salinger"),
        Book("978-0-306-40615-7", "To Kill a Mockingbird", "Harper Lee"),
        Book("978-0-7432-2679-0", "The Great Gatsby", "F. Scott Fitzgerald")
    )

    val isbnToBookMap: Map<String, Book> = books.associateBy { it.isbn }
    println(isbnToBookMap)
}