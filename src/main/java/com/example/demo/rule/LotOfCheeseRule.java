package com.example.demo.rule;

import com.example.demo.model.Snack;
import com.example.demo.model.SnackIngredient;

public class LotOfCheeseRule implements DiscountRule {
	
	private static final int QUEIJO = 5;
	private SnackIngredient snackIngredient;

	@Override
	public boolean isApplicable(Snack snack) {
		for (SnackIngredient snackIngredient : snack.getSnackIngredients()) {
			if (snackIngredient.getIngredient().getId() == QUEIJO && snackIngredient.getQuantity() >= 3) {
				this.snackIngredient = snackIngredient;
				return true;
			}
		}
		return false;
	}

	@Override
	public double calculateDiscount(Snack snack) {
		int discountMultiplier = 0;
		double cheesePrice = 0d;
		for (SnackIngredient snackIngredient : snack.getSnackIngredients()) {
			if (snackIngredient.getIngredient().getId() == QUEIJO && snackIngredient.getQuantity() >= 3) {
				discountMultiplier = snackIngredient.getQuantity() / 3;
				cheesePrice = snackIngredient.getIngredient().getPrice();
				break;
			}
		}
		return discountMultiplier * cheesePrice;
	}

}
