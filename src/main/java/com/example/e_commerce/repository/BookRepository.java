package com.example.e_commerce.repository;

import com.example.e_commerce.Model.BooksModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BooksModel, Integer> {

}
