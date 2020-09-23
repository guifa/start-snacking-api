package com.example.demo.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.example.demo.rule.evaluator.DiscountCalculator;

public class Snack {
	
	private int id;
	
	@NotNull
	private String name;
	
	private List<SnackIngredient> snackIngredients;
	
	public Snack(int id) {
		super();
		this.id = id;
	}
	
	public Snack() {
		
	}

	public double getTotalPrice() {
		DiscountCalculator discountCalculator = new DiscountCalculator();
		double totalPrice = 0d;
		double discount = 0d;
	
		for(SnackIngredient snackIngredient: snackIngredients) {
			if (snackIngredient.getIngredient() != null) {
				totalPrice += snackIngredient.getIngredient().getPrice() * snackIngredient.getQuantity();
			}
		}
		
		discount = discountCalculator.calculateDiscount(snackIngredients, totalPrice);
		
		return totalPrice - discount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SnackIngredient> getSnackIngredients() {
		return snackIngredients;
	}

	public void setSnackIngredients(List<SnackIngredient> snackIngredients) {
		this.snackIngredients = snackIngredients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Snack other = (Snack) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
