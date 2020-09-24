package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Snack;
import com.example.demo.service.SnackService;

@RestController
@RequestMapping("/snacks")
@CrossOrigin
public class SnackController {
	
	@Autowired
	private SnackService snackService;
	
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
