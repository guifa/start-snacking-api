package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Snack;
import com.example.demo.service.SnackService;

@RestController
@RequestMapping("/snacks")
public class SnackController {
	
	@Autowired
	private SnackService snackService;
	
	@GetMapping
    public ResponseEntity<List<Snack>> findAll() {
        List<Snack> snacks = snackService.findAll();
		
		return ResponseEntity.ok(snacks);
    }
	
	@PostMapping
	public ResponseEntity<Snack> save(@RequestBody Snack snack, HttpServletResponse response) {
		snackService.save(snack, response);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(snack);
	}

}
