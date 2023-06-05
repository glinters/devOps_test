package com.example.bookrecomendation.service;

import com.example.bookrecomendation.model.Book;
import com.example.bookrecomendation.model.User;
import com.example.bookrecomendation.repository.BookRepository;
import com.example.bookrecomendation.repository.UserRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookServiceImpl(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
//        if (bookList.isEmpty())
//            return null;
//        else
//            return bookList;
    }

    @Override
    public String prepareData() {
        bookRepository.saveAll(getFromJson());
        return "Done";
    }

    @Override
    public List<String> findAllGenres() {
        return bookRepository.findDistinctGenre();
    }

    @Override
    public List<String> findAllAuthors() {
        return bookRepository.findDistinctAuthor();
    }

    private List<Book> getFromJson() {
        try (InputStream inputStream = getClass().getResourceAsStream("/static/books.json");
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
            Type bookListType = new TypeToken<List<Book>>() {
            }.getType();
            return new Gson().fromJson(reader, bookListType);

            // Use the myObject instance as needed
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getRecommendations(String username) {
        List<Book> books = findAllBook();
        if(username != null){
            User user = userRepository.findById(username).orElse(null);
            if(user != null){
                return books.stream().filter(book ->
                        user.authors.isEmpty() && user.genres.isEmpty() || user.authors.stream().anyMatch(author ->
                                book.author.equals(author)) || user.genres.stream().anyMatch(genre -> book.genre.equals(genre))).limit(20).collect(Collectors.toList());
            }
        }
        return books.stream().limit(20).collect(Collectors.toList());
    }
}
