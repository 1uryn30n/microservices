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

import br.edu.ifms.microservices.model.minhasClasses.Secretario;
import br.edu.ifms.microservices.repository.SecretarioRepository;




@RestController
@RequestMapping(value = "/api/secretario")
public class SecretarioResource {
    
    @Autowired
    SecretarioRepository secretarioRepository;

    @GetMapping("/listar")
    public List<Secretario> mostrarAll(){
        return secretarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Secretario> buscaSecretario(@PathVariable (value = "id") long id) {
        return secretarioRepository.findById(id);
    }

    @PostMapping()
    public Secretario insert(@RequestBody Secretario secretario) {
        return secretarioRepository.save(secretario);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSecretario(@PathVariable("id") long id) throws Exception {
        Optional<Secretario>  secretario  = secretarioRepository.findById(id);
        if (secretario.get().getId() > 0) {
            secretarioRepository.deleteById(id);
        } else {
            System.out.println("Secretario não encontrado.");
        }
    }

    @PutMapping(value = "/{id}")
    public void atualizarSecretario(@PathVariable(value = "id") long id, @RequestBody Secretario novoSecretario) {
        Optional<Secretario> antigoSecretario= secretarioRepository.findById(id);
        if (antigoSecretario.get().getId() > 0) {
            novoSecretario.setId(antigoSecretario.get().getId());
            secretarioRepository.save(novoSecretario);
        }
    }

}
