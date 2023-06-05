package com.example.bookrecomendation.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    public String username;
    public String password;
    @ElementCollection
    public List<String> genres = new ArrayList<>();
    @ElementCollection
    public List<String> authors = new ArrayList<>();

}
