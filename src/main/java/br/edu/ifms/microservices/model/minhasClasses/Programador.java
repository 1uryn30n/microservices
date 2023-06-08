package br.edu.ifms.microservices.model.minhasClasses;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@javax.persistence.Entity
public class Programador {
    
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column()
    private String nome;

    @Column()
    private String cpf;
    
}
