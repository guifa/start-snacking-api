package com.example.demo.rule;

import com.example.demo.model.Snack;
import com.example.demo.model.SnackIngredient;

public class LotOfMeatRule implements DiscountRule {
	
	private static final int CARNE = 1;
	private SnackIngredient snackIngredient;

	@Override
	public boolean isApplicable(Snack snack) {
		for (SnackIngredient snackIngredient : snack.getSnackIngredients()) {
			if (snackIngredient.getIngredient().getId() == CARNE && snackIngredient.getQuantity() >= 3) {
				this.snackIngredient = snackIngredient;
				return true;
			}
		}
		return false;
	}

	@Override
	public double calculateDiscount(Snack snack) {
		int discountMultiplier = 0;
		double meatPrice = 0d;
		for (SnackIngredient snackIngredient : snack.getSnackIngredients()) {
			if (snackIngredient.getIngredient().getId() == CARNE && snackIngredient.getQuantity() >= 3) {
				discountMultiplier = snackIngredient.getQuantity() / 3;
				meatPrice = snackIngredient.getIngredient().getPrice();
				break;
			}
		}
		return discountMultiplier * meatPrice;
	}

}
