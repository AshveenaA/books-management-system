package com.example.bookManagement.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BooksModel {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookId;
    String bookName;
    String author;
    int price;

}
