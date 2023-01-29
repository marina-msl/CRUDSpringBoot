package com.mml.freshbo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mml.freshbo.model.Book;
import com.mml.freshbo.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository repository;

    public List <Book> findAll() {
        return repository.findAll();
    }

    public Book findById(Long id) {

        Optional<Book> bookOptional = repository.findById(id);

        Book book = null;

        if(bookOptional.isPresent()) {
            book = bookOptional.get();
        } else {
            book = new Book();
        }   
        return book;
    }

    public Book findByName(String name) {
        return repository.findByName(name);
    }

    public Book findByIsbn(String isbn) {
        return repository.findByIsbn(isbn);
    }

    public void saveBook(Book book) {
        repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
