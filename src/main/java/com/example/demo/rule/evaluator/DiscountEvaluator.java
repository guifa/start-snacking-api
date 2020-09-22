package com.example.demo.rule.evaluator;

import java.util.List;

import com.example.demo.model.SnackIngredient;

public interface DiscountEvaluator {
	
	double calculateDiscount(List<SnackIngredient> snackIngredients);

}
