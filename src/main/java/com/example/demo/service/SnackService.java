package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.SnackMapper;
import com.example.demo.model.Snack;

@Service
public class SnackService {

	@Autowired
	private SnackMapper snackMapper;

	public List<Snack> findAll() {
		return snackMapper.findAll();
	}
	
	public Snack save(Snack snack) {
		snackMapper.save(snack);
		
		return snack;
	}
}
