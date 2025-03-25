package com.culture_lib.library_service.dto

data class BookDto @JvmOverloads constructor(val id: BookIdDto? = null,
                                             val title: String? = "",
                                             val year: Int? = 0,
                                             val author: String? = "",
                                             val pressName: String? = "") {



}