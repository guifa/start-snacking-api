package com.example.demo.controller;

import com.example.demo.model.Ingredient;
import com.example.demo.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
@CrossOrigin
public class IngredientController {
	
	private final IngredientService ingredientService;

	public IngredientController(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}

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
