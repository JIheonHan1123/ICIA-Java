package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.NewBoard;

@Mapper
public interface NewBoardDao {
	@Insert("insert into newboard values(newboard_seq.nextval, #{title}, #{content}, #{writer}, 0)")
	public Long write(NewBoard newboard);

	public List<NewBoard> findAll(Long startRownum, Long endRownum);
}
