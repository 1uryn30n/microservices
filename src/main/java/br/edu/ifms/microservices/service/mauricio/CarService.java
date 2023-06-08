package br.edu.ifms.microservices.service.mauricio;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifms.microservices.config.Config;
import br.edu.ifms.microservices.model.consumivel.mauricio.Car;


@FeignClient(name = "Car", url = Config.MAURICIO_ADDRESS + "/car")  
public interface CarService {
    
    @GetMapping("/list")
    List<Car> getCars();
}
