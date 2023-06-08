package br.edu.ifms.microservices.controller.mauricio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.microservices.model.consumivel.mauricio.Country;
import br.edu.ifms.microservices.service.mauricio.CountryService;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

    @Autowired
    CountryService service;


    @GetMapping("/list")
    public ResponseEntity<List<Country>> getAll() {
        return ResponseEntity.ok(this.service.getCountries());
    }


}