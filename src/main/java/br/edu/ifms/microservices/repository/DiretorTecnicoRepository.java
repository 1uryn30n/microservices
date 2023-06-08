package br.edu.ifms.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.microservices.model.minhasClasses.DiretorTecnico;

public interface DiretorTecnicoRepository extends JpaRepository<DiretorTecnico,Long>{
    
}
