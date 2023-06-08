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

import br.edu.ifms.microservices.model.minhasClasses.DiretorTecnico;
import br.edu.ifms.microservices.repository.DiretorTecnicoRepository;

@RestController
@RequestMapping(value = "/api/diretorTecnico")
public class DiretorTecnicoResource {
    @Autowired
    DiretorTecnicoRepository diretorTecnicoRepository;


    @PostMapping()
    public DiretorTecnico insert(@RequestBody  DiretorTecnico diretorTecnico) {
        return diretorTecnicoRepository.save(diretorTecnico);
    }

    @GetMapping("/listar")
    public List<DiretorTecnico> mostrarAll() {
        return diretorTecnicoRepository.findAll();
    }


    @GetMapping("/{id}")
    public Optional<DiretorTecnico> buscaDiretorTecnico(@PathVariable(value = "id") long id) {
        return diretorTecnicoRepository.findById(id);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteDiretorTecnico(@PathVariable("id") long id) throws Exception {
        Optional<DiretorTecnico> diretorTecnico = diretorTecnicoRepository.findById(id);
        if (diretorTecnico.get().getId() > 0) {
            diretorTecnicoRepository.deleteById(id);
        } else {
            System.out.println("Diretor Subjacente não encontrado.");
        }
    }


    @PutMapping(value = "/{id}")
    public void atualizarDiretorTecnico(@PathVariable(value = "id") long id, @RequestBody DiretorTecnico novoDiretorTecnico) {
        Optional<DiretorTecnico> antigoDiretorTecnico = diretorTecnicoRepository.findById(id);
        if (antigoDiretorTecnico.get().getId() > 0) {
            novoDiretorTecnico.setId(antigoDiretorTecnico.get().getId());
            diretorTecnicoRepository.save(novoDiretorTecnico);
        }
    }

}
