package br.edu.ifms.microservices.model.consumivel.mauricio;

import lombok.Data;

@Data
public class User {
    
    private long id;

    private String name;
    
    private String email;

    private String password;
}
