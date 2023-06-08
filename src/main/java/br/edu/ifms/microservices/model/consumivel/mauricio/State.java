package br.edu.ifms.microservices.model.consumivel.mauricio;

import lombok.Data;

@Data
public class State {
    
    private long id;

    private String name;

    private String region;

    private String pib;

    private String population;
    
    private String capital;
}
