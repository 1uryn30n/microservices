package br.edu.ifms.microservices.service.mauricio;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifms.microservices.config.Config;
import br.edu.ifms.microservices.model.consumivel.mauricio.Country;




@FeignClient(name = "Country", url = Config.MAURICIO_ADDRESS + "/country")  
public interface CountryService {
    @GetMapping("/list")
    List<Country> getCountries();
}
