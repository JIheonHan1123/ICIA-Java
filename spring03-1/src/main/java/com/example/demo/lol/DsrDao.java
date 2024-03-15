package com.example.demo.lol;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DsrDao {
	@Select("select lane, round(count(case win when 'TRUE' then 1 end)/count(*), 4) as rate, round((sum(kills)+sum(assists))/sum(deaths)) as kda, round(avg(gold), 2) as gold from dsr where id =#{id} group by lane")
	public List<Map<String, Object>> findById(Long id);
}
