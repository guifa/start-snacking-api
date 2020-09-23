package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SnackTest {

	Snack snack;
	
	@Nested
	class LightRule {
		
		@BeforeEach
        void createSnack() {			
			List<SnackIngredient> snackIngredients = new ArrayList<SnackIngredient>();
			
			Ingredient lettuce = new Ingredient(1, "Lettuce", 0.4);
			SnackIngredient snackLettuce = new SnackIngredient(lettuce, 1);
			snackIngredients.add(snackLettuce);
			
			Ingredient meat = new Ingredient(3, "Meat", 3d);
			SnackIngredient snackMeat = new SnackIngredient(meat, 2);
			snackIngredients.add(snackMeat);
			
			Ingredient cheese = new Ingredient(5, "Cheese", 1.5);
			SnackIngredient snackCheese = new SnackIngredient(cheese, 2);
			snackIngredients.add(snackCheese);

			snack = new Snack(snackIngredients);
        }
		
		@Test
		@DisplayName("10 percent discount")
		void testGetTotalPrice() {
			assertEquals(8.46, snack.getTotalPrice());
		}

	}
	
	@Nested
	class LightRuleAndLotOfMeat {
		
		@BeforeEach
        void createSnack() {			
			List<SnackIngredient> snackIngredients = new ArrayList<SnackIngredient>();
			
			Ingredient lettuce = new Ingredient(1, "Lettuce", 0.4);
			SnackIngredient snackLettuce = new SnackIngredient(lettuce, 1);
			snackIngredients.add(snackLettuce);
			
			Ingredient meat = new Ingredient(3, "Meat", 3d);
			SnackIngredient snackMeat = new SnackIngredient(meat, 3);
			snackIngredients.add(snackMeat);
			
			Ingredient cheese = new Ingredient(5, "Cheese", 1.5);
			SnackIngredient snackCheese = new SnackIngredient(cheese, 2);
			snackIngredients.add(snackCheese);

			snack = new Snack(snackIngredients);
        }
		
		@Test
		@DisplayName("10 percent discount + for every three meat pay one less")
		void testGetTotalPrice() {
			assertEquals(8.16, snack.getTotalPrice());
		}

	}
	
	@Nested
	class AllDiscounts {
		
		@BeforeEach
        void createSnack() {			
			List<SnackIngredient> snackIngredients = new ArrayList<SnackIngredient>();
			
			Ingredient lettuce = new Ingredient(1, "Lettuce", 0.4);
			SnackIngredient snackLettuce = new SnackIngredient(lettuce, 1);
			snackIngredients.add(snackLettuce);
			
			Ingredient meat = new Ingredient(3, "Meat", 3d);
			SnackIngredient snackMeat = new SnackIngredient(meat, 10);
			snackIngredients.add(snackMeat);
			
			Ingredient cheese = new Ingredient(5, "Cheese", 1.5);
			SnackIngredient snackCheese = new SnackIngredient(cheese, 7);
			snackIngredients.add(snackCheese);

			snack = new Snack(snackIngredients);
        }
		
		@Test
		@DisplayName("10 percent discount + for every three meat pay one less + for every three cheese pay one less")
		void testGetTotalPrice() {
			assertEquals(24.81, snack.getTotalPrice());
		}

	}

}
