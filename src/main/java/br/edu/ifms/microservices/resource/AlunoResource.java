package br.edu.ifms.microservices.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.microservices.model.minhasClasses.Aluno;
import br.edu.ifms.microservices.repository.AlunoRepository;

@RestController
@RequestMapping(value = "/api/aluno")
public class AlunoResource {
    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping(value = "/{nome}")
    public String getMeunome(@PathVariable String nome) {
        return "My name is " + nome;
    }

    @GetMapping(value = "/nomesobrenome")
    public String getMeunomesobrenome(@RequestParam String nome, @RequestParam String sobrenome) {
        return "My name is " + nome + " " + sobrenome;
    }

    @PostMapping()
    public Aluno insert(@RequestBody  Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @GetMapping("/listar")
    public List<Aluno> mostrarAll() {
        return alunoRepository.findAll();
    }


    @GetMapping("/alunoid/{id}")
    public Optional<Aluno> buscaAluno(@PathVariable(value = "id") long id) {
        return alunoRepository.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAluno(@PathVariable("id") long id) throws Exception {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.get().getId() > 0) {
            alunoRepository.deleteById(id);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    @PutMapping(value = "/{id}")
    public void atualizarAluno(@PathVariable(value = "id") long id, @RequestBody Aluno novoAluno) {
        Optional<Aluno> antigoAluno = alunoRepository.findById(id);
        if (antigoAluno.get().getId() > 0) {
            novoAluno.setId(antigoAluno.get().getId());
            alunoRepository.save(novoAluno);
        }
    }

  
    @GetMapping(value = "/ListarAluno")
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

}
