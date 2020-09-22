package com.example.demo.exceptionhandler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.error.*;

@ControllerAdvice
public class StartSnackingExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ErrorHandler errorHandler;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String userMessage = messageSource.getMessage("bad.json", null, LocaleContextHolder.getLocale());
		String debugMessage = ex.getMessage();
		List<ErrorMessage> errorMessages = Arrays.asList(new ErrorMessage(userMessage, debugMessage));
		
		return handleExceptionInternal(ex, errorMessages, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ErrorMessage> errorMessages = errorHandler.createErrorMessages(ex.getBindingResult());
		
		return handleExceptionInternal(ex, errorMessages, headers, status, request);
	}
}
