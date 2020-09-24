package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.example.demo.model.Ingredient;

@Mapper
public interface IngredientMapper {
	
	@Select("select * from ingredient")
	List<Ingredient> findAll();
	
	@Insert("insert into ingredient(name,price) values(#{name},#{price})")
	@SelectKey(statement = "SELECT max(id) + 1 from ingredient", keyProperty = "id", before = true, resultType = int.class)
	Integer save(Ingredient ingredient);

}
