package br.edu.ifms.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.microservices.model.minhasClasses.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{
    
}
