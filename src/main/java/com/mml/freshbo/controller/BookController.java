package com.mml.freshbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
        Book book = service.findById(id);
        return  book;
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
    public void createBook(@RequestBody Book newBook) {
            service.saveBook(newBook);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Book bookNewInformations){
        Book book = service.findById(id);
        book.setName(bookNewInformations.getName());   
        book.setPublisher(bookNewInformations.getPublisher()); 
        book.setIsbn(bookNewInformations.getIsbn());
        service.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBook(id);
    }
}
