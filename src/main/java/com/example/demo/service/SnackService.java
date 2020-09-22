package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.demo.event.CreatedResourceEvent;
import com.example.demo.mapper.SnackIngredientMapper;
import com.example.demo.mapper.SnackMapper;
import com.example.demo.model.Snack;
import com.example.demo.model.SnackIngredient;

@Service
public class SnackService {

	@Autowired
	private SnackMapper snackMapper;
	
	@Autowired
	private SnackIngredientMapper snackIngredientMapper;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public List<Snack> findAll() {
		return snackMapper.findAll();
	}
	
	public Snack save(Snack snack, HttpServletResponse response) {
		snackMapper.save(snack);
		
		for (SnackIngredient snackIngredient : snack.getSnackIngredients()) {
			snackIngredient.setSnack(snack);
			snackIngredientMapper.save(snackIngredient);
		}
		
		applicationEventPublisher.publishEvent(new CreatedResourceEvent(this, response, snack.getId()));
		
		return snack;
	}
}
