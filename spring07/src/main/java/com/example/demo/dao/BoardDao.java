package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.Board;

@Mapper
public interface BoardDao {
	public Long save(Board board);

	@Select("select count(bno) from board")
	public Long count();

	public List<Board> findAll(Long startRownum, Long endRownum);

	//

	@Select("select * from board where bno=#{bno} and rownum=1")
	public Board findByBno(Long bno);

	@Update("update board set title=#{title}, content=#{content} where bno=#{bno} and rownum=1")
	public Long update(Board board);

	@Update("update board set read_cnt=read_cnt+1 where bno=#{bno} and rownum=1")
	public void increaseReadcnt(Long bno);

	@Delete("delete from board where bno=#{bno} and rownum=1")
	public Long deleteByBno(Long bno);

	@Update("update board set good_cnt=good_cnt+1 where bno=#{bno} and rownum=1")
	public Long increaseGoodCnt(Long bno);

	@Update("update board set bad_cnt=bad_cnt+1 where bno=#{bno} and rownum=1")
	public Long increaseBadCnt(Long bno);
}
