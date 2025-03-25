package com.culture_lib.book_service.dto

import com.culture_lib.book_service.model.Book
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator

data class BookDto @JvmOverloads constructor(
        val id: BookIdDto? = null,
        val title: String,
        val bookYear: Int,
        val author: String,
        val pressName: String
){
        companion object {
                @JvmStatic
                fun convert(from: Book): BookDto {
                        return BookDto(
                                from.id?.let { BookIdDto.convert(it, from.isbn) },
                                from.title,
                                from.bookYear,
                                from.author,
                                from.pressName
                        )
                }
        }
}