package com.example.demo.rule;

import java.util.HashMap;
import java.util.List;

import com.example.demo.model.SnackIngredient;

public class LightRule implements DiscountRule{

	static final int ALFACE = 1;
	static final int BACON = 2;
	
	@Override
	public boolean isApplicable(List<SnackIngredient> snackIngredients) {
		HashMap<Integer, Integer> ingredients = new HashMap<Integer, Integer>();
		for (SnackIngredient snackIngredient : snackIngredients) {
			ingredients.put(snackIngredient.getIngredient().getId(), snackIngredient.getQuantity());
		}
		if (ingredients.containsKey(ALFACE) && !ingredients.containsKey(BACON)) {
			return true;
		}
		return false;
	}

	@Override
	public double calculateDiscount(List<SnackIngredient> snackIngredients) {
		double totalPrice = 0d;
		for (SnackIngredient snackIngredient : snackIngredients) {
			totalPrice += snackIngredient.getIngredient().getPrice() * snackIngredient.getQuantity();
		}
		return 0.1 * totalPrice;
	}

}
