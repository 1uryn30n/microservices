package br.edu.ifms.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.microservices.model.minhasClasses.AnalistaDeDados;

public interface AnalistaDeDAdosRepository extends JpaRepository<AnalistaDeDados, Long>{
    
}
