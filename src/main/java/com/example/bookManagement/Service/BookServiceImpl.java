package com.example.bookManagement.Service;

import com.example.bookManagement.Model.BooksModel;
import com.example.bookManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@Service
public  class BookServiceImpl implements BookService {
   // private List<BooksModel> books = new ArrayList<>();
    private int nextId = 1;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BooksModel> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void createBook(BooksModel book) {
        book.setBookId(nextId++);
        bookRepository.save(book);
    }

    @Override
    public String deleteBook(int bookId) {
        Optional<BooksModel> deletedBookOptional=bookRepository.findById(bookId);
        BooksModel deletedBook=deletedBookOptional
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        bookRepository.delete(deletedBook);
        return "deleted";

    }

   @Override
    public BooksModel updateBook(BooksModel book, int bookId) {
        return null;
    }

    @Override
    public BooksModel updateBook(int bookId, BooksModel book) {
        Optional<BooksModel> savedBookOptional=bookRepository.findById(bookId);
        BooksModel savedBook=savedBookOptional
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        book.setBookId(bookId);
        savedBook=bookRepository.save(book);
        return savedBook;

    }



}
