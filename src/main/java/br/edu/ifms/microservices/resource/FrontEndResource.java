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

import br.edu.ifms.microservices.model.minhasClasses.FrontEnd;
import br.edu.ifms.microservices.repository.FrontEndRepository;


@RestController
@RequestMapping(value = "/api/frontEnd")
public class FrontEndResource {
    
    @Autowired
    FrontEndRepository frontEndRepository;

    @GetMapping("/listar")
    public List<FrontEnd> mostrarAll() {
        return frontEndRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<FrontEnd> buscaFrontEnd(@PathVariable(value = "id") long id) {
        return frontEndRepository.findById(id);
    }

    @PostMapping()
    public FrontEnd insert(@RequestBody  FrontEnd frontEnd) {
        return frontEndRepository.save(frontEnd);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFrontEnd(@PathVariable("id") long id) throws Exception {
        Optional<FrontEnd> frontEnd = frontEndRepository.findById(id);
        if (frontEnd.get().getId() > 0) {
            frontEndRepository.deleteById(id);
        } else {
            System.out.println("Diretor não encontrado.");
        }
    }

    @PutMapping(value = "/{id}")
    public void atualizarFrontEnd(@PathVariable(value = "id") long id, @RequestBody FrontEnd novoFrontEnd) {
        Optional<FrontEnd> antigoFrontEnd = frontEndRepository.findById(id);
        if (antigoFrontEnd.get().getId() > 0) {
            novoFrontEnd.setId(antigoFrontEnd.get().getId());
            frontEndRepository.save(novoFrontEnd);
        }
    }

}
