package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Sale;
import com.example.demo.service.SaleService;

@RestController
@RequestMapping("/sales")
@CrossOrigin
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<List<Sale>> findAll() {
        List<Sale> sale = saleService.findAll();
		
		return ResponseEntity.ok(sale);
    }
}
