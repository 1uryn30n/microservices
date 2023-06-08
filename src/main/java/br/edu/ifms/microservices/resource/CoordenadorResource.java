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

import br.edu.ifms.microservices.model.minhasClasses.Coordenador;
import br.edu.ifms.microservices.repository.CoordenadorRepository;

@RestController
@RequestMapping(value = "/api/coordenador")
public class CoordenadorResource {
    @Autowired
    CoordenadorRepository coordenadorRepository;

    @PostMapping()
    public Coordenador insert(@RequestBody  Coordenador coordenador) {
        return coordenadorRepository.save(coordenador);
    }

    @GetMapping("/listar")
    public List<Coordenador> mostrarAll() {
        return coordenadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Coordenador> buscaCoordenador(@PathVariable(value = "id") long id) {
        return coordenadorRepository.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCoordenador(@PathVariable("id") long id) throws Exception {
        Optional<Coordenador> coordenador = coordenadorRepository.findById(id);
        if (coordenador.get().getId() > 0) {
            coordenadorRepository.deleteById(id);
        } else {
            System.out.println("Coordenador não encontrado.");
        }
    }

    @PutMapping(value = "/{id}")
    public void atualizarCoordenador(@PathVariable(value = "id") long id, @RequestBody Coordenador novoCoordenador) {
        Optional<Coordenador> antigoCoordenador = coordenadorRepository.findById(id);
        if (antigoCoordenador.get().getId() > 0) {
            novoCoordenador.setId(antigoCoordenador.get().getId());
            coordenadorRepository.save(novoCoordenador);
        }
    }





}
