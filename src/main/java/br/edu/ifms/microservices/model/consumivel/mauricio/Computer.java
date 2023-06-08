package br.edu.ifms.microservices.model.consumivel.mauricio;

import lombok.Data;

@Data
public class Computer {
    
    private long id;

    private String name;

    private String brand;

    private String processor;

    private String operationalSystem;

    private String ramMemory;

    private String storage;
}
