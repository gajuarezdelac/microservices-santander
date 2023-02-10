package mx.santander.pcau.resolvers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.pcau.resolvers.config.Configuration;


@RestController
public class ResolversController {

	@Autowired
	Configuration configuration;

	@GetMapping("/endpoint")
	public String retrieveLimits() {
		return configuration.getValue();
	}
	
}
