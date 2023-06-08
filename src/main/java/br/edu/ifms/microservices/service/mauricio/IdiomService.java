package br.edu.ifms.microservices.service.mauricio;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifms.microservices.config.Config;
import br.edu.ifms.microservices.model.consumivel.mauricio.Idiom;



@FeignClient(name = "Idiom", url = Config.MAURICIO_ADDRESS + "/idiom")
public interface IdiomService {
    
    @GetMapping("/list")
    List<Idiom> getIdioms();
}
