package br.edu.ifms.microservices.controller.mauricio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.microservices.model.consumivel.mauricio.Book;
import br.edu.ifms.microservices.service.mauricio.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService service;


    @GetMapping("/list")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(this.service.getBooks());
    }


}
