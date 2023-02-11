package mx.santander.pcau.categories.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.santander.pcau.categories.exception.ExceptionGeneric;

@Service
public interface ICategoryService {
	
	List<Object> findCategories();

	Object addCategory() throws ExceptionGeneric;
}
