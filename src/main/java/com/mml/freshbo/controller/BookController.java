package com.mml.freshbo.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mml.freshbo.model.Book;
import com.mml.freshbo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping
    public List<Book> getAllBooks() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Optional<Book> book = service.findById(id);

        if (book.isEmpty()) {
            throw new NoSuchElementException("Book not found in the database");
        }

        return book.get();
    }

    // @GetMapping("/{name}") 
    // public Book getBookByName(@PathVariable String name) {
    //     Book book = service.findByName(name);
    //     return book;
    // }

    // @GetMapping("/{isbn}") 
    // public Book getBookByIsbn(@PathVariable String isbn) {
    //     Book book = service.findByIsbn(isbn);
    //     return book;
    // }

    @PostMapping
    public ResponseEntity<Object> createBook(@RequestBody Book newBook) {
            Book createdBook = service.saveBook(newBook);

    return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> bookOptional = service.findById(id);

        if (bookOptional.isEmpty()) {
            throw new NoSuchElementException("Book not found in the database");
        }

        book.setId(id);

        service.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Book> book = service.findById(id);

        if (book.isEmpty()) {
            throw new NoSuchElementException("Book not found in the database");
        }

        service.deleteBook(id);
    }
}
