package br.edu.ifms.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.microservices.model.minhasClasses.Programador;

public interface ProgramadorRepository extends JpaRepository<Programador, Long>{
    
    
}
