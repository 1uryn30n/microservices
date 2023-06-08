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

import br.edu.ifms.microservices.model.minhasClasses.Coach;
import br.edu.ifms.microservices.repository.CoachRepository;


@RestController
@RequestMapping(value = "/api/coach")
public class CoachResource {
    @Autowired
    CoachRepository coachRepository;

    @PostMapping("/insert")
    public Coach insert (@RequestBody  Coach coach){
        return coachRepository.save(coach);
    }

    @GetMapping("listar")
    public List<Coach> mostrarAll(){
        return coachRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Coach> buscaCoach(@PathVariable(value = "id") long id) {
        return coachRepository.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCoach(@PathVariable("id") long id) throws Exception {
        Optional<Coach> coach = coachRepository.findById(id);
        if (coach.get().getId() > 0) {
            coachRepository.deleteById(id);
        } else {
            System.out.println("Coach não encontrado.");
        }
    }
    @PutMapping(value = "/{id}")
    public void atualizarCoach(@PathVariable(value = "id") long id, @RequestBody Coach novoCoach) {
        Optional<Coach> antigoCoach = coachRepository.findById(id);
        if (antigoCoach.get().getId() > 0) {
            novoCoach.setId(antigoCoach.get().getId());
            coachRepository.save(novoCoach);
        }
    }

}
