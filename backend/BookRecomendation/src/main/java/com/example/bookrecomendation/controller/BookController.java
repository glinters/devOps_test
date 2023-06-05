package com.example.bookrecomendation.controller;

import com.example.bookrecomendation.model.Book;
import com.example.bookrecomendation.service.BookServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    final BookServiceImpl bookServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @GetMapping("/findAll")
    public List<Book> findAll() {
        return bookServiceImpl.findAllBook();
    }

    @GetMapping("/prepareData")
    public String prepareData() {
        return bookServiceImpl.prepareData();
    }

    @GetMapping("/findAllGenres")
    public List<String> findAllGenres() {
        return bookServiceImpl.findAllGenres();
    }

    @GetMapping("/findAllAuthors")
    public List<String> findAllAuthors() {
        return bookServiceImpl.findAllAuthors();
    }

    @GetMapping("/getRecomendations/{username}")
    public List<Book> getRecomendations(@PathVariable String username) {
        return bookServiceImpl.getRecommendations(username);
    }

}
