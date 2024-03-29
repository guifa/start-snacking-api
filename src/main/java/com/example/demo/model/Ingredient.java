package com.example.demo.model;

import javax.validation.constraints.NotNull;

public class Ingredient {
	
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private double price;		
	
	public Ingredient(int id, @NotNull String name, @NotNull double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public Ingredient() {

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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
		Ingredient other = (Ingredient) obj;
		return id == other.id;
	}
	
}
