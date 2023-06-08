package br.edu.ifms.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.microservices.model.minhasClasses.FrontEnd;

public interface FrontEndRepository extends JpaRepository <FrontEnd, Long> {
    
}
