package com.culture_lib.book_service.service;

import com.culture_lib.book_service.dto.BookIdDto;
import com.culture_lib.book_service.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BookServiceTest {

    // Class under test
    private BookService bookService;
    private BookRepository bookRepository;

    @org.junit.Before
    public void setUp() throws Exception {
        bookRepository = Mockito.mock(BookRepository.class);

        bookService = new BookService(bookRepository);
    }

    @Test
    public void whenFindByIsbn_thenReturnValidBookIdDto() {
        // Arrange data
        String isbn = "";
        BookIdDto bookIdDto = new BookIdDto("1", isbn);

        // Act mock behavior
        Mockito.when(bookService.findByIsbn(isbn)).thenReturn(bookIdDto);

        // Call the testing method
        BookIdDto resultDto = bookService.findByIsbn(isbn);

        //Assert
        Assert.assertEquals(resultDto, bookIdDto);
        // Verify if the methods in the mock object is called
        Mockito.verify(bookRepository).getBookByIsbn(isbn);
    }

    /*
    @Test
    public void whenFindByIsbnWithNonvalidIsbn_thenReturnNotFoundException() {
        // Arrange data
        String isbn = "12345";
        BookIdDto bookIdDto = new BookIdDto("1", isbn);

        // Act mock behavior
        Mockito.when(bookService.findByIsbn(isbn)).thenReturn(bookIdDto);

        // Call the testing method
        BookIdDto resultDto = bookService.findByIsbn(isbn);

        //Assert
        Assert.assertEquals(resultDto, bookIdDto);
        // Verify if the methods in the mock object is called
        Mockito.verify(bookRepository).getBookByIsbn(isbn);
    }
     */
    @org.junit.Test
    public void getAllBooks() {
    }

    @org.junit.Test
    public void findByIsbn() {
    }

    @org.junit.Test
    public void findBookDetailsById() {
    }
}