package mx.santander.pcau.cecos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.pcau.cecos.config.Configuration;

@RestController
public class CecoController {
	
	@Autowired
	Configuration configuration;

	@GetMapping("/endpoint")
	public String retrieveLimits() {
		return configuration.getValue();
	}


}
