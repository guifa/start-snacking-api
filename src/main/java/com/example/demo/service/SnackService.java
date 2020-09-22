package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.demo.event.CreatedResourceEvent;
import com.example.demo.mapper.SnackMapper;
import com.example.demo.model.Snack;

@Service
public class SnackService {

	@Autowired
	private SnackMapper snackMapper;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public List<Snack> findAll() {
		return snackMapper.findAll();
	}
	
	public Snack save(Snack snack, HttpServletResponse response) {
		snackMapper.save(snack);
		
		applicationEventPublisher.publishEvent(new CreatedResourceEvent(this, response, snack.getId()));
		
		return snack;
	}
}
