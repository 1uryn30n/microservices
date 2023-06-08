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
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.microservices.model.minhasClasses.Diretor;
import br.edu.ifms.microservices.repository.DiretorRepository;

@RestController
@RequestMapping(value = "/api/diretor")
public class DiretorResource {
    @Autowired
    DiretorRepository diretorRepository;

    @GetMapping(value ="/{nome}")
    public String getMeunome(@PathVariable String nome){
        return "My name is " + nome;
    }


    @PostMapping()
    public Diretor insert(@RequestBody  Diretor diretor) {
        return diretorRepository.save(diretor);
    }

    @GetMapping("/listar")
    public List<Diretor> mostrarAll() {
        return diretorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Diretor> buscaDiretor(@PathVariable(value = "id") long id) {
        return diretorRepository.findById(id);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteDiretor(@PathVariable("id") long id) throws Exception {
        Optional<Diretor> diretor = diretorRepository.findById(id);
        if (diretor.get().getId() > 0) {
            diretorRepository.deleteById(id);
        } else {
            System.out.println("Diretor não encontrado.");
        }
    }

    @PutMapping(value = "/{id}")
    public void atualizarDiretor(@PathVariable(value = "id") long id, @RequestBody Diretor novoDiretor) {
        Optional<Diretor> antigoDiretor = diretorRepository.findById(id);
        if (antigoDiretor.get().getId() > 0) {
            novoDiretor.setId(antigoDiretor.get().getId());
            diretorRepository.save(novoDiretor);
        }
    }


}
