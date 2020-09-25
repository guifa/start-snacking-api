package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Sale;

@Mapper
public interface SaleMapper {
	
	@Select("select * from sale")
	List<Sale> findAll();

}
