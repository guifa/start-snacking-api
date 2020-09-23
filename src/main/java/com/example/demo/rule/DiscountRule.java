package com.example.demo.rule;

import java.util.List;

import com.example.demo.model.SnackIngredient;

public interface DiscountRule {
	
	boolean isApplicable(List<SnackIngredient> snackIngredients);
	
	double calculateDiscount(List<SnackIngredient> snackIngredients, double snackTotalPrice);

}
