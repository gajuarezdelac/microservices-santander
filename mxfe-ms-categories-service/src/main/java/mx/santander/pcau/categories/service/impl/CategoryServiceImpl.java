package mx.santander.pcau.categories.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mx.santander.pcau.categories.exception.ExceptionGeneric;
import mx.santander.pcau.categories.service.ICategoryService;


@Component
public class CategoryServiceImpl implements ICategoryService{

	@Override
	public List<Object> findCategories() {
	
		List<Object> response = new ArrayList<>();
		response.add("First element");
		response.add("Second element");
		response.add("Third element");
		response.add("Fourth element ");
		
		return response;
	}

	@Override
	public Object addCategory() throws ExceptionGeneric {
	   throw new ExceptionGeneric("Exception example");
	}
}
