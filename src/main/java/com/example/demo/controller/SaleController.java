package com.example.demo.controller;

import com.example.demo.model.Sale;
import com.example.demo.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")
@CrossOrigin
public class SaleController {

	private final SaleService saleService;

	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}

	@GetMapping
	public ResponseEntity<List<Sale>> findAll() {
        List<Sale> sale = saleService.findAll();
		
		return ResponseEntity.ok(sale);
    }
}
