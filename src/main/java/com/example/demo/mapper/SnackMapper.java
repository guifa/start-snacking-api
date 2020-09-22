package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.demo.model.Ingredient;
import com.example.demo.model.Snack;
import com.example.demo.model.SnackIngredient;

@Mapper
public interface SnackMapper {
	
	@Results(id = "snackResultMap", value = {
	  @Result(property = "id", column = "ID"),
	  @Result(property = "name", column = "SNACK_NAME"),
	  @Result(property = "snackIngredients", column = "ID", many = @Many(select = "selectIngredientsForSnack"))
	})
	@Select("SELECT S.ID, S.NAME AS SNACK_NAME FROM SNACK S")
    List<Snack> findAll();
	
	@ResultMap("snackResultMap")
	@Select("SELECT S.ID, S.NAME AS SNACK_NAME FROM SNACK S WHERE S.ID = #{snackId}")
	Snack findById(@Param("snackId") Integer snackId);
	
	
	@Results({
	  @Result(property = "ingredient", column = "ID_INGREDIENT", one = @One(select = "selectIngredient")),
	  @Result(property = "quantity", column = "QUANTITY")
	})
	@Select("SELECT SI.ID_INGREDIENT, SI.QUANTITY FROM SNACK_INGREDIENT SI WHERE ID_SNACK = #{snackId}")
	List<SnackIngredient> selectIngredientsForSnack(@Param("snackId") Integer snackId);
	
	@Results({
	  @Result(property = "id", column = "ID"),
	  @Result(property = "name", column = "NAME"),
	  @Result(property = "price", column = "PRICE")
	})
	@Select("SELECT I.ID, I.NAME, I.PRICE FROM INGREDIENT I WHERE I.ID= #{ingredientId}")
	Ingredient selectIngredient(@Param("ingredientId") Integer ingredientId);
	
	@Insert("insert into snack(name) values(#{name})")
	@SelectKey(statement = "SELECT max(id) + 1 from snack", keyProperty = "id", before = true, resultType = int.class)
	Integer save(Snack snack);

}
