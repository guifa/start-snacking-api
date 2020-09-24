package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ingredient;
import com.example.demo.service.IngredientService;

@RestController
@RequestMapping("/ingredients")
@CrossOrigin
public class IngredientController {
	
	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping
	public ResponseEntity<List<Ingredient>> findAll() {
        List<Ingredient> ingredients = ingredientService.findAll();
		
		return ResponseEntity.ok(ingredients);
    }
	
	@PostMapping
	public ResponseEntity<Ingredient> save(@Valid @RequestBody Ingredient ingredient, HttpServletResponse response) {
		ingredientService.save(ingredient, response);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ingredient);
	}

}
