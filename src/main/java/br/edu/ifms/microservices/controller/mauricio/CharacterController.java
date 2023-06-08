package br.edu.ifms.microservices.controller.mauricio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.microservices.service.mauricio.CharacterService;


@RestController
@RequestMapping(value = "/character")
public class CharacterController {

    @Autowired
    CharacterService service;


    @GetMapping("/list")
    public ResponseEntity<List<Character>> getAll() {
        return ResponseEntity.ok(this.service.getCharacters());
    }


}