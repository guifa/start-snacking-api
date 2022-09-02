package com.example.demo.error;

public class ErrorMessage {
	
	private final String userMessage;
	private final String debugMessage;
	
	public ErrorMessage(String userMessage, String debugMessage) {
		this.userMessage = userMessage;
		this.debugMessage = debugMessage;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public String getDebugMessage() {
		return debugMessage;
	}
}
