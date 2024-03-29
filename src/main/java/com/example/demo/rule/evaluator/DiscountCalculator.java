package com.example.demo.rule.evaluator;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.SnackIngredient;
import com.example.demo.rule.DiscountRule;
import com.example.demo.rule.HealthyRule;
import com.example.demo.rule.LotsOfIngredientsRule;

public class DiscountCalculator implements DiscountEvaluator {
	
	private static final int MEAT = 3;
	private static final int CHEESE = 5;
	
	List<DiscountRule> rules = new ArrayList<DiscountRule>();
	
	public DiscountCalculator() {
		rules.add(new HealthyRule());
		rules.add(new LotsOfIngredientsRule(CHEESE));
		rules.add(new LotsOfIngredientsRule(MEAT));
	}

	@Override
	public double calculateDiscount(List<SnackIngredient> snackIngredients, double snackTotalPrice) {
		double discount = 0d;
		
		for (DiscountRule discountRule : rules) {
			if (discountRule.isApplicable(snackIngredients)) {
				discount += discountRule.calculateDiscount(snackIngredients, snackTotalPrice);
			}
		}
		
		return discount;
	}
	
	public void addRule(DiscountRule discountRule) {
		rules.add(discountRule);
	}

	public List<DiscountRule> getRules() {
		return rules;
	}

	public void setRules(List<DiscountRule> rules) {
		this.rules = rules;
	}

}
