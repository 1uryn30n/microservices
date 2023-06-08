package br.edu.ifms.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.microservices.model.minhasClasses.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long>{
    
}
