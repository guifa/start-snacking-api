package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.mapper.IngredientMapper;
import com.example.demo.model.Ingredient;
import com.example.demo.service.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
	
	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping
    public ResponseEntity<List<Ingredient>> findAll() {
        List<Ingredient> ingredients = ingredientService.findAll();
		
		return ResponseEntity.ok(ingredients);
    }
	
	@PostMapping
	public ResponseEntity<Ingredient> save(@RequestBody Ingredient ingredient) {
		ingredientService.save(ingredient);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ingredient);
	}

}
