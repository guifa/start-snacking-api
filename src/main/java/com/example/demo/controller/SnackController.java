package com.example.demo.controller;

import com.example.demo.model.Snack;
import com.example.demo.service.SnackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/snacks")
@CrossOrigin
public class SnackController {
	
	private final SnackService snackService;

	public SnackController(SnackService snackService) {
		this.snackService = snackService;
	}

	@GetMapping
	public ResponseEntity<List<Snack>> findAll() {
        List<Snack> snacks = snackService.findAll();
		
		return ResponseEntity.ok(snacks);
	}
	
	@GetMapping("/{snackId}")
	public ResponseEntity<Snack> findById(@PathVariable Integer snackId) {
		Snack snack = snackService.findById(snackId);
		
		return snack != null ? ResponseEntity.ok(snack) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Snack> save(@Valid @RequestBody Snack snack, HttpServletResponse response) {
		snackService.save(snack, response);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(snack);
	}

}
