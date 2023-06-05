package com.example.bookrecomendation.repository;

import com.example.bookrecomendation.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query("SELECT DISTINCT e.genre FROM Book e")
    List<String> findDistinctGenre();
    @Query("SELECT DISTINCT e.author FROM Book e")
    List<String> findDistinctAuthor();
}
