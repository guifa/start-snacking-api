package com.example.demo.rule;

import java.util.HashMap;
import java.util.List;

import com.example.demo.model.SnackIngredient;

public class HealthyRule implements DiscountRule{

	static final String LETTUCE = "Alface";
	static final String BACON = "Bacon";
	static final double TEN_PERCENT_DISCOUNT = 0.1;	
	
	@Override
	public boolean isApplicable(List<SnackIngredient> snackIngredients) {
		HashMap<String, Integer> ingredients = new HashMap<>();
		for (SnackIngredient snackIngredient : snackIngredients) {
			ingredients.put(snackIngredient.getIngredient().getName(), snackIngredient.getQuantity());
		}
		return ingredients.containsKey(LETTUCE) && !ingredients.containsKey(BACON);
	}

	@Override
	public double calculateDiscount(List<SnackIngredient> snackIngredients, double snackTotalPrice) {
		return TEN_PERCENT_DISCOUNT * snackTotalPrice;
	}

}
