package com.example.demo.sample1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SampleDao2 {
	// 부서 번호 지정
	@Select("select * from dept where deptno=#{deptno}")
	public Dept findByDeptno1(Long deptno);

	@Select("select * from dept where deptno=#{deptno}")
	public Map<String, Object> findByDeptno2(Long deptno);

	// ex01) position을 입력하면 emp2에서 출력하시오
	@Select("select * from emp2 where position=#{position}")
	public List<Map<String, Object>> findByPosition(String position);

	// ex02) deptno와 job을 입력받아 emp를 출력하는 sql과 method
	@Select("select * from emp where deptno=#{deptno} and job=#{job}")
	public List<Map<String, Object>> findByDeptnoAndJob(Long deptno, String job);

	// ex03) 직위와 부서를 입력받아 해당하는 insa 테이블의 행을 출력
	@Select("select * from insa where jikwi=#{jikwi} and buseo=#{buseo}")
	public List<Map<String, Object>> findByJikwiAndBuseo(String jikwi, String buseo);

	// ex04) city가 서울 또는 경기인 insa 테이블의 행을 출력
	@Select("select * from insa where city=#{city1} and city=#{city2})")
	public List<Map<String, Object>> findByCity(String city1, String city2);
}
