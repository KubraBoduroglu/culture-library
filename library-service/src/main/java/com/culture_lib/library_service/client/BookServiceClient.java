package com.culture_lib.library_service.client;

import com.culture_lib.library_service.dto.BookDto;
import com.culture_lib.library_service.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service", path = "/v1/book")
// library-service is a client to book-service using this interface
public interface BookServiceClient {

    @GetMapping("/isbn/{isbn}")
     ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn);

    @GetMapping("/book/{id}")
    ResponseEntity<BookDto> getBookById(@PathVariable String id);


}
