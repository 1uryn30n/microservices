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

import br.edu.ifms.microservices.model.minhasClasses.Tecnico;
import br.edu.ifms.microservices.repository.TecnicoRepository;


@RestController
@RequestMapping(value = "/api/tecnico")
public class TecnicoResource {
    
    @Autowired
    TecnicoRepository tecnicoRepository;

    @GetMapping("/listar")
    public List<Tecnico> mostrarAll(){
        return tecnicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Tecnico> buscaTecnico(@PathVariable (value = "id") long id) {
        return tecnicoRepository.findById(id);
    }


    @PostMapping()
    public Tecnico insert(@RequestBody Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTecnico(@PathVariable("id") long id) throws Exception {
        Optional<Tecnico> tecnico  = tecnicoRepository.findById(id);
        if (tecnico.get().getId()> 0) {
            tecnicoRepository.deleteById(id);
        } else {
            System.out.println("Secretario não encontrado.");
        }
    }


    @PutMapping(value = "/{id}")
    public void atualizarTecnico(@PathVariable(value = "id") long id, @RequestBody Tecnico novoTecnico) {
        Optional<Tecnico> antigoTecnico= tecnicoRepository.findById(id);
        if (antigoTecnico.get().getId() > 0) {
            novoTecnico.setId(antigoTecnico.get().getId());
            tecnicoRepository.save(novoTecnico);
        }
    }

}
