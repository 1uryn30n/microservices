package br.edu.ifms.microservices.service.mauricio;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifms.microservices.config.Config;


@FeignClient(name = "Character", url = Config.MAURICIO_ADDRESS + "/character")  
public interface CharacterService {
        
    @GetMapping("/list")
    List<Character> getCharacters();
}
