package com.example.demo.rule.evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import com.example.demo.model.*;
import com.example.demo.rule.*;

class DiscountCalculatorTest {

	public static final String LETTUCE = "Alface";
	public static final String MEAT = "Meat";
	public static final String CHEESE = "Cheese";
	DiscountCalculator discountCalculator = new DiscountCalculator();
	List<SnackIngredient> snackIngredients;
	
	@Nested
	class NoRules {
		
		@BeforeEach
        void createSnackIngredientsList() {
			snackIngredients = new ArrayList<SnackIngredient>();
			
			Ingredient lettuce = new Ingredient(1, LETTUCE, 0.4);
			SnackIngredient snackLettuce = new SnackIngredient(lettuce, 1);
			snackIngredients.add(snackLettuce);
			
			Ingredient meat = new Ingredient(3, MEAT, 3d);
			SnackIngredient snackMeat = new SnackIngredient(meat, 3);
			snackIngredients.add(snackMeat);
			
			Ingredient cheese = new Ingredient(5, CHEESE, 1.5);
			SnackIngredient snackCheese = new SnackIngredient(cheese, 3);
			snackIngredients.add(snackCheese);
			
			discountCalculator.setRules(new ArrayList<DiscountRule>());
        }
		
		@Test
		@DisplayName("No discount")
		void testCalculateDiscount() {
			assertEquals(0d, discountCalculator.calculateDiscount(snackIngredients, 13.9));
		}

	}
	
	@Nested
	class AllRules {
		
		@BeforeEach
        void createSnackIngredientsList() {
			snackIngredients = new ArrayList<SnackIngredient>();
			
			Ingredient lettuce = new Ingredient(1, LETTUCE, 0.4);
			SnackIngredient snackLettuce = new SnackIngredient(lettuce, 1);
			snackIngredients.add(snackLettuce);
			
			Ingredient meat = new Ingredient(3, MEAT, 3d);
			SnackIngredient snackMeat = new SnackIngredient(meat, 3);
			snackIngredients.add(snackMeat);
			
			Ingredient cheese = new Ingredient(5, CHEESE, 1.5);
			SnackIngredient snackCheese = new SnackIngredient(cheese, 6);
			snackIngredients.add(snackCheese);
			
        }
		
		@Test
		@DisplayName("10 percent discount + for every three meat pay one less + for every three cheese pay one less")
		void testCalculateDiscount() {
			assertEquals(7.84, discountCalculator.calculateDiscount(snackIngredients, 18.4));
		}

	}

}
