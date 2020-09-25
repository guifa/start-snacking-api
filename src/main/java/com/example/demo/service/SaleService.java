package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.SaleMapper;
import com.example.demo.model.Sale;

@Service
public class SaleService {

	@Autowired
	private SaleMapper saleMapper;
	
	public List<Sale> findAll() {
		return saleMapper.findAll();
	}
}
