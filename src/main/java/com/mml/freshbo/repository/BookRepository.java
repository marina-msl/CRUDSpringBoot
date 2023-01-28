package com.mml.freshbo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mml.freshbo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);
}
