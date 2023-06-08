package br.edu.ifms.microservices.model.consumivel.mauricio;

import lombok.Data;

@Data
public class Country {
    
    private long id;

    private String name;

    private String continent;

    private String pib;

    private String population;
    
    private String capital;

    private String leader;
}
