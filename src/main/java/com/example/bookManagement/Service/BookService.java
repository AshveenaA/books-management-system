package com.example.bookManagement.Service;

import com.example.bookManagement.Model.BooksModel;
import java.util.List;

public interface BookService {
    List<BooksModel> getBooks();
   void createBook(BooksModel book);
    String deleteBook(int bookId);

   BooksModel updateBook(BooksModel book,int bookId);

    BooksModel updateBook(int bookId, BooksModel book);
}
