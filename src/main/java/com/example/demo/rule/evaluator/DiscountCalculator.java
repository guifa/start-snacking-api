package com.example.demo.rule.evaluator;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Snack;
import com.example.demo.rule.*;

public class DiscountCalculator implements DiscountEvaluator {
	
	List<DiscountRule> rules = new ArrayList<DiscountRule>();
	
	public DiscountCalculator() {
		rules.add(new LightRule());
		rules.add(new LotOfCheeseRule());
		rules.add(new LotOfMeatRule());
	}

	@Override
	public double calculateDiscount(Snack snack) {
		double discount = 0d;
		
		for (DiscountRule discountRule : rules) {
			discount += discountRule.calculateDiscount(snack);
		}
		
		return discount;
	}

}
