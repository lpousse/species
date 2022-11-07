package fr.diginamic.species.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	/*private final String TEMPLATE_ERROR = "error.html";
	
	private final String ATTRIBUTE_ERROR_MESSAGE = "errorMessage";
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String generalException(Exception ex, Model model)
	{
		model.addAttribute(ATTRIBUTE_ERROR_MESSAGE, ex.getMessage());
        return TEMPLATE_ERROR;
    }*/
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String generalException(Exception ex) {
        return ex.getMessage();
    }
}