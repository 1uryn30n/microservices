package br.edu.ifms.microservices.model.consumivel.mauricio;

import lombok.Data;

@Data
public class Animal {
    
    private long id;

    private String name;

    private String species;

    private String classification;
}
