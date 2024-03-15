package com.example.demo.march14;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao {
	// 기존 방식에서 sql 분리 -> 기존 방식은 sql에 오타가 나도 에러체크가 안된다
	// -> sql을 작성하기 위해 application.properties에 설정을 잡아주자
	public List<String> findPosition(); // emp2에서 distinct 직위

	public List<Long> countGroupByPosition(); // emp2에서 직위별 인원수

	public List<Map<String, Object>> countGroupByPosition2(); // emp2에서 직위, 인원수

	public List<Map<String, Object>> countGroupByPosition3();
}
