package com.example.demo.rule;

import java.util.HashMap;

import com.example.demo.model.Snack;
import com.example.demo.model.SnackIngredient;

public class LightRule implements DiscountRule{

	static final int ALFACE = 1;
	static final int BACON = 2;
	
	@Override
	public boolean isApplicable(Snack snack) {
		HashMap<Integer, Integer> ingredients = new HashMap<Integer, Integer>();
		for (SnackIngredient snackIngredient : snack.getSnackIngredients()) {
			ingredients.put(snackIngredient.getIngredient().getId(), snackIngredient.getQuantity());
		}
		if (ingredients.containsKey(ALFACE) && !ingredients.containsKey(BACON)) {
			return true;
		}
		return false;
	}

	@Override
	public double calculateDiscount(Snack snack) {
		return 0.1 * snack.getTotalPrice();
	}

}
