package mx.santander.pcau.categories.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import mx.santander.pcau.categories.domain.response.HttpResponse;

@RestControllerAdvice
public class ExceptionHandling implements ErrorController{
		
	    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	    private static final String METHOD_IS_NOT_ALLOWED = "This request method is not allowed on this endpoint. Please send a '%s' request";
	    private static final String INTERNAL_SERVER_ERROR_MSG = "An error occurred while processing the request";
	    private static final String ERROR_PROCESSING_FILE = "Error occurred while processing file";
	    private static final String NOT_ENOUGH_PERMISSION = "You do not have enough permission";
	    public static final String ERROR_PATH = "/error";
	    
	    Map<String, Object> result = new HashMap<String,Object>();
	    
	  
	    @ExceptionHandler(AccessDeniedException.class)
	    public ResponseEntity<HttpResponse> accessDeniedException() {
	        return createHttpResponse(FORBIDDEN,getResponseCode(FORBIDDEN, NOT_ENOUGH_PERMISSION, "ERROR", NOT_ENOUGH_PERMISSION, NOT_ENOUGH_PERMISSION), false);
	    }
	     
	    @ExceptionHandler(ExceptionGeneric.class)
	    public ResponseEntity<HttpResponse> emailNotFoundException(ExceptionGeneric exception) {
	        return createHttpResponse(BAD_REQUEST,getResponseCode(BAD_REQUEST,exception.getMessage(), "", "", ""), false);
	    }
	    
	    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	    public ResponseEntity<HttpResponse> methodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
	        HttpMethod supportedMethod = Objects.requireNonNull(exception.getSupportedHttpMethods()).iterator().next();
	        return createHttpResponse(METHOD_NOT_ALLOWED, getResponseCode(METHOD_NOT_ALLOWED, String.format(METHOD_IS_NOT_ALLOWED, supportedMethod), "", "", ""),false);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<HttpResponse> internalServerErrorException(Exception exception) {
	        LOGGER.error(exception.getMessage());
	        return createHttpResponse(INTERNAL_SERVER_ERROR, getResponseCode(INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MSG, "", "", ""),false);
	    }
	    
	    @ExceptionHandler(NoResultException.class)
	    public ResponseEntity<HttpResponse> notFoundException(NoResultException exception) {
	        LOGGER.error(exception.getMessage());
	        return createHttpResponse(NOT_FOUND, getResponseCode(NOT_FOUND, exception.getMessage(), "" , "", ""),false);
	    }

	    
	    @ExceptionHandler(IOException.class)
	    public ResponseEntity<HttpResponse> iOException(IOException exception) {
	        LOGGER.error(exception.getMessage());
	        return createHttpResponse(INTERNAL_SERVER_ERROR, getResponseCode(INTERNAL_SERVER_ERROR, ERROR_PROCESSING_FILE, "", "", ""), false);
	    }
	    
	    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus , Map<String, Object> responseCode,Boolean ok) {
	        return new ResponseEntity<>(new HttpResponse(ok,responseCode, result), httpStatus);
	    }
	    
	    private Map<String, Object> getResponseCode(HttpStatus code, String message, String level, String description, String moreInfo) {
	    	
	    	Map<String, Object> responseCode = new HashMap<String,Object>();
	    	responseCode.put("code",code);
	    	responseCode.put("message",message);
	    	responseCode.put("level",level);
	    	responseCode.put("description",description);
	    	responseCode.put("moreInfo",moreInfo);
	    	
	    	
	    	return responseCode;
	    }
	    
	    @RequestMapping(ERROR_PATH)
	    public ResponseEntity<HttpResponse> notFound404() {
	        return createHttpResponse(NOT_FOUND,getResponseCode(NOT_FOUND,"There is no mapping for this URL", "", "", "" ),false);
	    }
	    
	    public String getErrorPath() {
	        return ERROR_PATH;
	    }

	}

