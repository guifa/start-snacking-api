package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

import com.example.demo.model.SnackIngredient;

@Mapper
public interface SnackIngredientMapper {
	
	@Insert("insert into snack_ingredient(id_ingredient, id_snack, quantity) values(#{ingredient.id}, #{snack.id}, #{quantity})")
	@SelectKey(statement = "SELECT max(id) + 1 from snack_ingredient", keyProperty = "id", before = true, resultType = int.class)
	Integer save(SnackIngredient snackIngredient);


}
