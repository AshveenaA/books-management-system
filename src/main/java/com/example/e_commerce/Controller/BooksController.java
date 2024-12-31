package com.example.e_commerce.Controller;

import com.example.e_commerce.Model.BooksModel;
import com.example.e_commerce.Service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BooksController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BooksModel>> getBooks() {
        return new ResponseEntity<>( bookService.getBooks(),HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<String> createBook(@RequestBody BooksModel book) {
        try {
            bookService.createBook(book);
            return new ResponseEntity<>("Book added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception (if necessary) and return a 500 status with an error message
            return new ResponseEntity<>("Error adding book: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookId) {
        try {
            String status = bookService.deleteBook(bookId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable int bookId, @RequestBody BooksModel book) {
        try {
            BooksModel updatedBook = bookService.updateBook(bookId, book);
            return new ResponseEntity<>("The book with ID " + bookId + " was successfully updated.", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            System.out.println("Error: " + e.getReason());
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}