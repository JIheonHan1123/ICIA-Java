package com.example.demo.sample1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// @Repositoty: 스프링이 dao빈을 생성

// 마이바티스가 dao를 생성해서 스프링에 등록
@Mapper
public interface SampleDao4 {
	@Select("select deptno, count(*) as cnt from emp2 group by deptno order by 2 desc")
	public List<Map<String, Object>> findCountByDeptno();

	@Select("select lane, round(avg(gold), 2) from dsr where id=#{id} group by lane having count(*)>=100")
	public List<Map<String, Object>> findGoldByLane(Long id);

	@Select("select lane, round(avg(damagedealt/duration),2) as dps from dsr where id=#{id} group by lane")
	public List<Map<String, Object>> findDps(Long id);

	@Select("select lane, round((count(decode(win, 'TRUE', 1)))/(count(win)),2) 승률, round(((sum(kills)+sum(assists))/sum(deaths)),2) as kda, sum(gold)from dsr where id=#{id} group by lane order by 2 desc")
	public List<Map<String, Object>> findSKG(Long id);
}
