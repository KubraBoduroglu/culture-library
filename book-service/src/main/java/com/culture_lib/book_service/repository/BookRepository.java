package com.culture_lib.book_service.repository;

import com.culture_lib.book_service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository  extends JpaRepository<Book, String> {
    Optional<Book> getBookByIsbn(String isbn);
}
