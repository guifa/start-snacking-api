package com.example.demo.rule;

import java.util.HashMap;
import java.util.List;

import com.example.demo.model.SnackIngredient;

public class LightRule implements DiscountRule{

	static final int ALFACE = 1;
	static final int BACON = 2;
	static final double TEN_PERCENT_DISCOUNT = 0.1;
	
	private double snackTotalPrice;
	
	@Override
	public boolean isApplicable(List<SnackIngredient> snackIngredients) {
		HashMap<Integer, Integer> ingredients = new HashMap<Integer, Integer>();
		for (SnackIngredient snackIngredient : snackIngredients) {
			ingredients.put(snackIngredient.getIngredient().getId(), snackIngredient.getQuantity());
			this.snackTotalPrice += snackIngredient.getIngredient().getPrice() * snackIngredient.getQuantity();
		}
		if (ingredients.containsKey(ALFACE) && !ingredients.containsKey(BACON)) {
			return true;
		}
		return false;
	}

	@Override
	public double calculateDiscount(List<SnackIngredient> snackIngredients) {
		return TEN_PERCENT_DISCOUNT * this.snackTotalPrice;
	}

}
