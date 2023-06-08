package br.edu.ifms.microservices.model.consumivel.mauricio;

import lombok.Data;

@Data
public class Car {
    
    private long id;

    private String name;

    private String releaseYear;

    private String acceleration;

    private String cylinderConfiguration;

    private String brand;
}
