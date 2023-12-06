package com.example.demo.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(DataIntegrityViolationException.class)
	    @ResponseStatus(HttpStatus.CONFLICT)
	    public String handleIntegrityConstraintViolation(DataIntegrityViolationException ex, Model model) {
	        // Log the exception if necessary
	        // You can redirect to a specific error page (error_page.jsp) or return a view name here


	        return "fail";
	 }
}
