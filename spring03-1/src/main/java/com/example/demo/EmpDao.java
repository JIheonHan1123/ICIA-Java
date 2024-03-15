package com.example.demo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDao {
	public List<Map<String, Object>> findAll();

	public Map<String, Object> findByEname(Long empno);
}
