package com.example.demo.rule;

import com.example.demo.model.Snack;

public interface DiscountRule {
	
	boolean isApplicable(Snack snack);
	
	double calculateDiscount(Snack snack);

}
