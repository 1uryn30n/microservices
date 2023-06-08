package br.edu.ifms.microservices.controller.mauricio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.microservices.model.consumivel.mauricio.State;
import br.edu.ifms.microservices.service.mauricio.StateService;

@RestController
@RequestMapping(value = "/state")
public class StateController {

    @Autowired
    StateService service;


    @GetMapping("/list")
    public ResponseEntity<List<State>> getAll() {
        return ResponseEntity.ok(this.service.getStates());
    }


}