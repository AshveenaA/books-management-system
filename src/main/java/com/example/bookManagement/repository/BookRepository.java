package com.example.bookManagement.repository;

import com.example.bookManagement.Model.BooksModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BooksModel, Integer> {

}
