package br.edu.ifms.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.microservices.model.minhasClasses.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
