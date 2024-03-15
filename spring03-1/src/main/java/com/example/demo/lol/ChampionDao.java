package com.example.demo.lol;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChampionDao {
	@Select("select * from champion where rownum<=10")
	public List<Map<String, Object>> findAll();
}
