package com.example.demo;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface InsaDao {

	@Select("select * from insa where ibsadate between #{startDay} and #{endDay}")
	public void insa(LocalDate startDay, LocalDate endDay);
}
