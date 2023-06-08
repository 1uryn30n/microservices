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

import br.edu.ifms.microservices.model.minhasClasses.Programador;
import br.edu.ifms.microservices.repository.ProgramadorRepository;


@RestController
@RequestMapping(value = "/api/programador")
public class ProgramadorResource {
    @Autowired
    ProgramadorRepository programadorRepository;

    @GetMapping("/listar")
    public List<Programador> mostrarAll(){
        return programadorRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Programador> buscaProgramador(@PathVariable (value = "id") long id) {
        return programadorRepository.findById(id);
    }

    @PostMapping()
    public Programador insert(@RequestBody  Programador programador) {
        return programadorRepository.save(programador);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProgramador(@PathVariable("id") long id) throws Exception {
        Optional<Programador>  programador  = programadorRepository.findById(id);
        if (programador.get().getId() > 0) {
            programadorRepository.deleteById(id);
        } else {
            System.out.println("Programador não encontrado.");
        }
    }

    @PutMapping(value = "/{id}")
    public void atualizarProgramador(@PathVariable(value = "id") long id, @RequestBody Programador novoProgramador) {
        Optional<Programador> antigoProgramador = programadorRepository.findById(id);
        if (antigoProgramador.get().getId() > 0) {
            novoProgramador.setId(antigoProgramador.get().getId());
            programadorRepository.save(novoProgramador);
        }
    }

    
}