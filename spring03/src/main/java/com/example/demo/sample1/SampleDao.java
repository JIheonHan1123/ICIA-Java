package com.example.demo.sample1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SampleDao {
	@Select("select distinct job from emp order by 1 desc")
	public List<String> findJob();
	// 컨트롤러가 없기 때문에 Junit으로 테스트

	// ex01) dsr테이블에 lane을 출력
	@Select("select distinct lane from dsr")
	public List<String> findLane();

	// ex02) 여러 컬럼을 읽어오는 경우에 "클래스를 만들어서 객체 생성" 또는 "Map"으로 처리
	// Map이 사용하기에 더 간편하지만 오타에 취약함
	// Map: 데이터의 이름과 값의 쌍 (객체와 역할은 동일. 클래스(설계도)없이 작업) ex) js의 객체 = 자바의 Map
	@Select("select * from dept")
	public List<Map<String, Object>> findAll1();
	// Map은 데이터 한 행을 읽어오는거고 여러행을 읽어오려면 Map을 모은 List형태로 처리

	// ex03) ex02를 클래스로 처리
	@Select("select * from dept")
	public List<Dept> findAll();

	@Select("select count(*) as count, avg(sal) as sal from emp")
	public Map<String, Object> count();

	@Select("select MAX(sal) as 최대급여, MIN(sal) as 최소급여 from emp")
	public Map<String, Object> calcMandM();

}
