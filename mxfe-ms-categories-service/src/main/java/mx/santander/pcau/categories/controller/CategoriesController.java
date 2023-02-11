package mx.santander.pcau.categories.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.santander.pcau.categories.config.Configuration;
import mx.santander.pcau.categories.domain.response.HttpResponse;
import mx.santander.pcau.categories.exception.ExceptionGeneric;
import mx.santander.pcau.categories.service.ICategoryService;

@RestController
@RequestMapping(path = "categories")
public class CategoriesController {

	@Autowired
	Configuration configuration;

	@Autowired
	ICategoryService service;

	@GetMapping("/endpoint")
	public String retrieveLimits() {
		return configuration.getValue();
	}

	@GetMapping("/list")
	public ResponseEntity<HttpResponse> getCategories() {
		List<Object> response = service.findCategories();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", response);
		return response(HttpStatus.OK, "Listado de categorias", true, result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<HttpResponse> addCategory(
			@RequestParam(value = "name", defaultValue = "", required = false) String name) throws ExceptionGeneric {
		Object response = service.addCategory();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", response);
		return response(HttpStatus.OK, "Nueva categoria", true, result);
	}

	
	private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message, Boolean code,
			Map<String, Object> result) {
		return new ResponseEntity<>(new HttpResponse(code, getResponseCode(httpStatus, message), result), httpStatus);
	}

	private Map<String, Object> getResponseCode(HttpStatus code, String message) {
		Map<String, Object> responseCode = new HashMap<String, Object>();
		responseCode.put("code", code);
		responseCode.put("message", message);
		responseCode.put("level", "SUCCESS");
		responseCode.put("description", "");
		responseCode.put("moreInfo", "");
		return responseCode;
	}

}
