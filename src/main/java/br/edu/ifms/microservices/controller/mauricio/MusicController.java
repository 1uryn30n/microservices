package br.edu.ifms.microservices.controller.mauricio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.microservices.model.consumivel.mauricio.Music;
import br.edu.ifms.microservices.service.mauricio.MusicService;

@RestController
@RequestMapping(value = "/music")
public class MusicController {

    @Autowired
    MusicService service;


    @GetMapping("/list")
    public ResponseEntity<List<Music>> getAll() {
        return ResponseEntity.ok(this.service.getMusics());
    }


}