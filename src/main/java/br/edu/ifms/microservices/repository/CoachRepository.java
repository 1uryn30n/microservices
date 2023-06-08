package br.edu.ifms.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.microservices.model.minhasClasses.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long>{
    
}
