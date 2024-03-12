package com.example.demo.sample1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SampleDao3 {
	// dsr에서 side별 골드 평균 출력
	@Select("select side, avg(gold) from dsr group by side")
	public List<Map<String, Object>> findGoldAvgPerSide();

	// dsr에서 라인별 골드 평균을 평균금액 내림차순으로 출력
	@Select("select lane, avg(gold) from dsr group by lane order by 2")
	public List<Map<String, Object>> findGoldAvgPerLane();

	// 라인("Supporter")을 입력 받아 평균 골드, 평균 데미지(damagealt)를 출력
	@Select("select avg(gold), avg(damagedealt) from dsr where lane=#{lane}")
	public Map<String, String> findGoldAvgAndDamPerLane(String Lane);
}
