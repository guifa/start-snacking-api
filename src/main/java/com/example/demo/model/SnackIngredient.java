package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SnackIngredient {
	
	@JsonIgnore
	private int id;
	
	private Ingredient ingredient;
	
	@JsonIgnore
	private Snack snack;
	
	private int quantity;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Snack getSnack() {
		return snack;
	}

	public void setSnack(Snack snack) {
		this.snack = snack;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		SnackIngredient other = (SnackIngredient) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
