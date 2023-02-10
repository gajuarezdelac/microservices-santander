package mx.santander.pcau.subjects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.pcau.subjects.config.Configuration;


@RestController
public class SubjectController {

	@Autowired
	Configuration configuration;

	@GetMapping("/endpoint")
	public String retrieveLimits() {
		return configuration.getValue();
	}
	
}
