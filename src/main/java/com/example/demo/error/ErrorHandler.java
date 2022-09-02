package com.example.demo.error;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Component
public class ErrorHandler {

	private final MessageSource messageSource;
	
	private List<ErrorMessage> errorMessages;
	
	public ErrorHandler(MessageSource messageSource) {
		errorMessages = new ArrayList<>();
		this.messageSource = messageSource;
	}
	
	public List<ErrorMessage> createErrorMessages(BindingResult bindingResult) {
		errorMessages = new ArrayList<>();
		String userMessage;
		String debugMessage;
		
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			userMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			debugMessage = fieldError.toString();
			errorMessages.add(new ErrorMessage(userMessage, debugMessage));
		}
		
		return errorMessages;
	}
}
