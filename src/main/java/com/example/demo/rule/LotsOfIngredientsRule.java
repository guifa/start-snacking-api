package com.example.demo.rule;

import java.util.List;

import com.example.demo.model.SnackIngredient;

public class LotsOfIngredientsRule implements DiscountRule {
	
	private final int ingredientId;
	
	private SnackIngredient snackIngredient;
	
	public LotsOfIngredientsRule(int ingredientId) {
		super();
		this.ingredientId = ingredientId;
	}

	@Override
	public boolean isApplicable(List<SnackIngredient> snackIngredients) {
		for (SnackIngredient snackIngredient : snackIngredients) {
			if (snackIngredient.getIngredient().getId() == this.ingredientId && snackIngredient.getQuantity() >= 3) {
				this.snackIngredient = snackIngredient;
				return true;
			}
		}
		return false;
	}

	@Override
	public double calculateDiscount(List<SnackIngredient> snackIngredients, double snackTotalPrice) {
		int discountMultiplier = snackIngredient.getQuantity() / 3;
		double ingredientPrice = snackIngredient.getIngredient().getPrice();
		
		return discountMultiplier * ingredientPrice;
	}

}
