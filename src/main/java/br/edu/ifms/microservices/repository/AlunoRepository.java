package br.edu.ifms.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.microservices.model.minhasClasses.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    //public Aluno findById(long id);
}
