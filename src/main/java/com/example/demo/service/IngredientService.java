package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.demo.event.CreatedResourceEvent;
import com.example.demo.mapper.IngredientMapper;
import com.example.demo.model.Ingredient;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientMapper ingredientMapper;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	public List<Ingredient> findAll() {
		return ingredientMapper.findAll();
	}
	
	public Ingredient save(Ingredient ingredient, HttpServletResponse response) {
		ingredientMapper.save(ingredient);
		
		applicationEventPublisher.publishEvent(new CreatedResourceEvent(this, response, ingredient.getId()));
		
		return ingredient;
	}
	
}
