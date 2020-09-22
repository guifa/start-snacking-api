package com.example.demo.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class CreatedResourceEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;

	private HttpServletResponse response;
	private int resourceId;
	
	public CreatedResourceEvent(Object source, HttpServletResponse response, int resourceId) {
		super(source);
		this.response = response;
		this.resourceId = resourceId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public int getResourceId() {
		return resourceId;
	}

}
