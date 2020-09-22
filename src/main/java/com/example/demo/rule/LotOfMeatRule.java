package com.example.demo.rule;

import java.util.List;

import com.example.demo.model.SnackIngredient;

public class LotOfMeatRule implements DiscountRule {
	
	private static final int CARNE = 3;
	
	private SnackIngredient snackIngredient;

	@Override
	public boolean isApplicable(List<SnackIngredient> snackIngredients) {
		for (SnackIngredient snackIngredient : snackIngredients) {
			if (snackIngredient.getIngredient().getId() == CARNE && snackIngredient.getQuantity() >= 3) {
				this.snackIngredient = snackIngredient;
				return true;
			}
		}
		return false;
	}

	@Override
	public double calculateDiscount(List<SnackIngredient> snackIngredients) {
		int discountMultiplier = this.snackIngredient.getQuantity() / 3;
		double meatPrice = this.snackIngredient.getIngredient().getPrice();
		
		return discountMultiplier * meatPrice;
	}

}
