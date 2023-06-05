package com.example.bookrecomendation.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    public String name;
    public String author;
    public String genre;
    @Column( length = 10000 )
    public String summary;

}
