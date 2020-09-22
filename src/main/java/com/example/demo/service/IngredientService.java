package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.IngredientMapper;
import com.example.demo.model.Ingredient;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientMapper ingredientMapper;
	
	public List<Ingredient> findAll() {
		return ingredientMapper.findAll();
	}
	
	public Ingredient save(Ingredient ingredient) {
		ingredientMapper.save(ingredient);
		
		return ingredient;
	}
	
}
