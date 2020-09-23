package com.example.demo.rule;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.example.demo.model.Ingredient;
import com.example.demo.model.SnackIngredient;

class LotOfIngredientRuleTest {
	
	static final int INGREDIENT_WITH_DISCOUNT_ID = 3;

	LotOfIngredientRule lotOfIngredientRule = new LotOfIngredientRule(INGREDIENT_WITH_DISCOUNT_ID);
	List<SnackIngredient> snackIngredients;
	
	void createSnackIngredients(int quantity) {
		snackIngredients = new ArrayList<SnackIngredient>();
		
		Ingredient lettuce = new Ingredient(1, "Lettuce", 0.4);
		SnackIngredient snackLettuce = new SnackIngredient(lettuce, 1);
		snackIngredients.add(snackLettuce);
		
		Ingredient meat = new Ingredient(3, "Meat", 3d);
		SnackIngredient snackMeat = new SnackIngredient(meat, quantity);
		snackIngredients.add(snackMeat);
	}
	
	@Nested
	class OneIngredient {
		
		@BeforeEach
        void createSnackIngredientsList() {
			createSnackIngredients(1);
        }
		
		@Test
		@DisplayName("Will give discount?")
		void testIsApplicable() {
			assertFalse(lotOfIngredientRule.isApplicable(snackIngredients));
		}

	}
	
	@Nested
	class TwoIngredient {
		
		@BeforeEach
        void createSnackIngredientsList() {
			createSnackIngredients(2);
        }
		
		@Test
		@DisplayName("Will give discount?")
		void testIsApplicable() {
			assertFalse(lotOfIngredientRule.isApplicable(snackIngredients));
		}

	}
	
	@Nested
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	class ThreeIngredient {
		
		@BeforeEach
        void createSnackIngredientsList() {
			createSnackIngredients(3);
        }
		
		@Test
		@DisplayName("Will give discount?")
		void testIsApplicable() {
			assertTrue(lotOfIngredientRule.isApplicable(snackIngredients));
		}
		
		@Test
		@DisplayName("Calculate discount")
		void testCalculateDiscount() {
			assertEquals(3, lotOfIngredientRule.calculateDiscount(snackIngredients, 9.4));
		}

	}
	
	@Nested
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	class SixIngredient {
		
		@BeforeEach
        void createSnackIngredientsList() {
			createSnackIngredients(6);
        }
		
		@Test
		@DisplayName("Will give discount?")
		void testIsApplicable() {
			assertTrue(lotOfIngredientRule.isApplicable(snackIngredients));
		}
		
		@Test
		@DisplayName("Calculate discount")
		void testCalculateDiscount() {
			assertEquals(6, lotOfIngredientRule.calculateDiscount(snackIngredients, 9.4));
		}

	}
	
}
