package br.edu.ifms.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.microservices.model.minhasClasses.Secretario;

public interface SecretarioRepository extends JpaRepository<Secretario, Long> {
    
}
