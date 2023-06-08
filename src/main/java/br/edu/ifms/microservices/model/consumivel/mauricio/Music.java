package br.edu.ifms.microservices.model.consumivel.mauricio;

import lombok.Data;

@Data
public class Music {
    
    private long id;

    private String name;

    private String artist;
    
    private int releaseYear;
    
    private String album;
    
    private String genres;
}
