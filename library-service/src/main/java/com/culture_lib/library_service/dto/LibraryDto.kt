package com.culture_lib.library_service.dto

data class LibraryDto @JvmOverloads constructor(
    val id: String? = "",
    val userBookList: List<BookDto>? = ArrayList()
    // List<BookDto> can be null then return ArrayList. Kotlin creates second constructor and can use it if needed
) {

}