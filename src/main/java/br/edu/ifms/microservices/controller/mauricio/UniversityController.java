package br.edu.ifms.microservices.controller.mauricio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.microservices.model.consumivel.mauricio.University;
import br.edu.ifms.microservices.service.mauricio.UniversityService;

@RestController
@RequestMapping(value = "/university")
public class UniversityController {

    @Autowired
    UniversityService service;


    @GetMapping("/list")
    public ResponseEntity<List<University>> getAll() {
        return ResponseEntity.ok(this.service.getUniversities());
    }


}