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

import br.edu.ifms.microservices.model.minhasClasses.AnalistaDeDados;
import br.edu.ifms.microservices.repository.AnalistaDeDAdosRepository;

@RestController
@RequestMapping(value = "/api/analizadedados")
public class AnalistaDeDadosResource {
    @Autowired
    AnalistaDeDAdosRepository analistaDeDadosRepository;

    @PostMapping()
    public AnalistaDeDados insert(@RequestBody  AnalistaDeDados analistaDeDados) {
        return analistaDeDadosRepository.save(analistaDeDados);
    }
    
    @GetMapping("/listar")
    public List<AnalistaDeDados> mostrarAll() {
        return analistaDeDadosRepository.findAll();
    }


    @GetMapping("/{id}")
    public Optional<AnalistaDeDados> buscaAnalistaDeDados(@PathVariable(value = "id") long id) {
        return analistaDeDadosRepository.findById(id);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteAnalistaDeDados(@PathVariable("id") long id) throws Exception {
        Optional<AnalistaDeDados> analistaDeDados = analistaDeDadosRepository.findById(id);
        if (analistaDeDados.get().getId() > 0) {
            analistaDeDadosRepository.deleteById(id);
        } else {
            System.out.println("não encontrado.");
        }
    }

    @PutMapping(value = "/{id}")
    public void atualizarAnalistaDeDados(@PathVariable(value = "id") long id, @RequestBody AnalistaDeDados novoAnalistaDeDados) {
        Optional<AnalistaDeDados> antigoAnalistaDeDados = analistaDeDadosRepository.findById(id);
        if (antigoAnalistaDeDados.get().getId() > 0) {
            novoAnalistaDeDados.setId(antigoAnalistaDeDados.get().getId());
            analistaDeDadosRepository.save(novoAnalistaDeDados);
        }
    }
}