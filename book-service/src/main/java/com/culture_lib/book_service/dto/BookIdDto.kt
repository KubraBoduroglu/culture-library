package com.culture_lib.book_service.dto

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator

data class BookIdDto @JvmOverloads constructor(
        val bookId: String? = "",
        val isbn: String
){
    companion object {
        @JvmStatic
        fun convert(id: String, isbn: String): BookIdDto {
            return  BookIdDto(id, isbn)
        }
    }
}