package com.example.bookrecomendation.service;

import com.example.bookrecomendation.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBook();

    String prepareData();

    List<String> findAllGenres();

    List<String> findAllAuthors();
}
