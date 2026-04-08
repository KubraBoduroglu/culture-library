package com.culture_lib.book_service.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.GeneratorType
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.IdGeneratorType
import org.hibernate.annotations.UuidGenerator
import java.time.Year

@Entity
@Table(name = "books")
data class Book @JvmOverloads constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String? = null,
        val title: String,
        val bookYear: Int,
        val author: String,
        val pressName: String,
        val isbn: String
)