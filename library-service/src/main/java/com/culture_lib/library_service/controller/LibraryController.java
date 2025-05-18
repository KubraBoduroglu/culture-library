package com.culture_lib.library_service.controller;

import com.culture_lib.library_service.dto.AddBookRequest;
import com.culture_lib.library_service.dto.LibraryDto;
import com.culture_lib.library_service.service.LibraryService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/v1/library")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id) {
        return ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));
    }

    // Creates an empty library object and returns it
    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary() {
        return ResponseEntity.ok(libraryService.createLibrary());
    }

    // Adds a book to the library
    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request) {
        libraryService.addBookToLibrary(request);
        return ResponseEntity.ok().build();
    }
}
