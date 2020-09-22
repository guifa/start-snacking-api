package com.example.demo.rule;

import java.util.List;

import com.example.demo.model.SnackIngredient;

public class LotOfIngredientRule implements DiscountRule {
	
	private int ingredientId;
	
	private SnackIngredient snackIngredient;
	
	public LotOfIngredientRule(int ingredientId) {
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
	public double calculateDiscount(List<SnackIngredient> snackIngredients) {
		int discountMultiplier = snackIngredient.getQuantity() / 3;
		double ingredientPrice = snackIngredient.getIngredient().getPrice();
		
		return discountMultiplier * ingredientPrice;
	}

}
