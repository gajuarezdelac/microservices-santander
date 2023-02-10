package mx.santander.pcau.forms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.pcau.forms.config.Configuration;

@RestController
public class FormController {
	
	@Autowired
	Configuration configuration;

	@GetMapping("/endpoint")
	public String retrieveLimits() {
		return configuration.getValue();
	}

}
