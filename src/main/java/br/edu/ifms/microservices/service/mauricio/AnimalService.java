package br.edu.ifms.microservices.service.mauricio;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifms.microservices.config.Config;
import br.edu.ifms.microservices.model.consumivel.mauricio.Animal;



@FeignClient(name = "Animal", url = Config.MAURICIO_ADDRESS + "/animal")  
public interface AnimalService {
    
    @GetMapping("/list")
    List<Animal> getAnimals();
}
