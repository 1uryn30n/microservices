package br.edu.ifms.microservices.controller.mauricio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.microservices.model.consumivel.mauricio.Animal;
import br.edu.ifms.microservices.service.mauricio.AnimalService;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {
    
    @Autowired
    AnimalService service;


    @GetMapping("/list")
    public ResponseEntity<List<Animal>> getAll() {
        return ResponseEntity.ok(this.service.getAnimals());
    }


}
