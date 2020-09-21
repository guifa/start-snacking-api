package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.SnackMapper;
import com.example.demo.model.Snack;

@RestController
@RequestMapping("/snacks")
public class SnackController {
	
	@Autowired
	private SnackMapper snackMapper;
	
	@GetMapping
    public ResponseEntity<List<Snack>> findAll() {
        List<Snack> snacks = snackMapper.findAll();
		
		return ResponseEntity.ok(snacks);
    }

}
