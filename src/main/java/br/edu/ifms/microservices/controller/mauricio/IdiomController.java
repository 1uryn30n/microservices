package br.edu.ifms.microservices.controller.mauricio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifms.microservices.model.consumivel.mauricio.Idiom;
import br.edu.ifms.microservices.service.mauricio.IdiomService;

@RestController
@RequestMapping(value = "/idiom")
public class IdiomController {

    @Autowired
    IdiomService service;


    @GetMapping("/list")
    public ResponseEntity<List<Idiom>> getAll() {
        return ResponseEntity.ok(this.service.getIdioms());
    }


}