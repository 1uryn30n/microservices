package br.edu.ifms.microservices.controller.mauricio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.microservices.model.consumivel.mauricio.Car;
import br.edu.ifms.microservices.service.mauricio.CarService;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    CarService service;


    @GetMapping("/list")
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(this.service.getCars());
    }


}