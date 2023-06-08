package br.edu.ifms.microservices.service.mauricio;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifms.microservices.config.Config;
import br.edu.ifms.microservices.model.consumivel.mauricio.State;



@FeignClient(name = "State", url = Config.MAURICIO_ADDRESS + "/state")  
public interface StateService {
    @GetMapping("/list")
    List<State> getStates();
}
