package br.edu.ifms.microservices.controller.mauricio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.microservices.model.consumivel.mauricio.Computer;
import br.edu.ifms.microservices.service.mauricio.ComputerService;

@RestController
@RequestMapping(value = "/computer")
public class ComputerController {

    @Autowired
    ComputerService service;


    @GetMapping("/list")
    public ResponseEntity<List<Computer>> getAll() {
        return ResponseEntity.ok(this.service.getComputers());
    }


}