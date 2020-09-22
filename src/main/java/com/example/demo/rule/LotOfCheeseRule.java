package com.example.demo.rule;

import java.util.List;

import com.example.demo.model.SnackIngredient;

public class LotOfCheeseRule implements DiscountRule {
	
	private static final int QUEIJO = 5;
	
	private SnackIngredient snackIngredient;

	@Override
	public boolean isApplicable(List<SnackIngredient> snackIngredients) {
		for (SnackIngredient snackIngredient : snackIngredients) {
			if (snackIngredient.getIngredient().getId() == QUEIJO && snackIngredient.getQuantity() >= 3) {
				this.snackIngredient = snackIngredient;
				return true;
			}
		}
		return false;
	}

	@Override
	public double calculateDiscount(List<SnackIngredient> snackIngredients) {
		int discountMultiplier = snackIngredient.getQuantity() / 3;
		double cheesePrice = snackIngredient.getIngredient().getPrice();
		
		return discountMultiplier * cheesePrice;
	}

}
