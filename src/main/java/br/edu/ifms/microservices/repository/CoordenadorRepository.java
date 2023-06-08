package br.edu.ifms.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.microservices.model.minhasClasses.Coordenador;

public interface CoordenadorRepository extends JpaRepository <Coordenador, Long>{
    
}
