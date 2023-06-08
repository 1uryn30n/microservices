package br.edu.ifms.microservices.model.consumivel.mauricio;

import lombok.Data;

@Data
public class Book {
    
    private long id;

    private String name;

    private String author;

    private int releaseYear;

    private int chapters;
}
