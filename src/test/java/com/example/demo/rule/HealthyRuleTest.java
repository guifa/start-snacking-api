package com.example.demo.rule;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Ingredient;
import com.example.demo.model.SnackIngredient;

class HealthyRuleTest {
	
	HealthyRule healthyRule = new HealthyRule();
	List<SnackIngredient> snackIngredients;
	
	@Nested
	class WithLettuceAndBacon {
		
		@BeforeEach
        void createSnackIngredientsList() {
			snackIngredients = new ArrayList<SnackIngredient>();
			
			Ingredient lettuce = new Ingredient(1, "Alface", 0.4);
			SnackIngredient snackLettuce = new SnackIngredient(lettuce, 1);
			snackIngredients.add(snackLettuce);
			
			Ingredient bacon = new Ingredient(2, "Bacon", 2d);
			SnackIngredient snackBacon = new SnackIngredient(bacon, 1);
			snackIngredients.add(snackBacon);
        }
		
		@Test
		@DisplayName("Will give discount?")
		void testIsApplicable() {
			assertFalse(healthyRule.isApplicable(snackIngredients));
		}

	}
	
	@Nested
	class WithLettuceNoBacon {
		
		@BeforeEach
        void createSnackIngredientsList() {
			snackIngredients = new ArrayList<SnackIngredient>();
			
			Ingredient lettuce = new Ingredient(1, "Alface", 0.4);
			SnackIngredient snackLettuce = new SnackIngredient(lettuce, 1);
			snackIngredients.add(snackLettuce);
			
			Ingredient meat = new Ingredient(3, "Meat", 3d);
			SnackIngredient snackMeat = new SnackIngredient(meat, 1);
			snackIngredients.add(snackMeat);
        }
		
		@Test
		@DisplayName("Will give discount?")
		void testIsApplicable() {
			assertTrue(healthyRule.isApplicable(snackIngredients));
		}

		@Test
		@DisplayName("Calculate discount")
		void testCalculateDiscount() {
			assertEquals(0.34, healthyRule.calculateDiscount(snackIngredients, 3.4));
		}
	}
	
}
