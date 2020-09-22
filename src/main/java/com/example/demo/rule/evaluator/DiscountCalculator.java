package com.example.demo.rule.evaluator;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.SnackIngredient;
import com.example.demo.rule.DiscountRule;
import com.example.demo.rule.LightRule;
import com.example.demo.rule.LotOfCheeseRule;
import com.example.demo.rule.LotOfMeatRule;

public class DiscountCalculator implements DiscountEvaluator {
	
	List<DiscountRule> rules = new ArrayList<DiscountRule>();
	
	public DiscountCalculator() {
		rules.add(new LightRule());
		rules.add(new LotOfCheeseRule());
		rules.add(new LotOfMeatRule());
	}

	@Override
	public double calculateDiscount(List<SnackIngredient> snackIngredients) {
		double discount = 0d;
		
		for (DiscountRule discountRule : rules) {
			if (discountRule.isApplicable(snackIngredients)) {
				discount += discountRule.calculateDiscount(snackIngredients);
			}
		}
		
		return discount;
	}

}
