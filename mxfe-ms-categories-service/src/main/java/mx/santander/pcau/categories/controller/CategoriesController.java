package mx.santander.pcau.categories.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.pcau.categories.config.Configuration;

@RestController
public class CategoriesController {

	@Autowired
	Configuration configuration;

	@GetMapping("/endpoint")
	public String retrieveLimits() {
		return configuration.getValue();
	}

}
