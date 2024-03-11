package com.example.demo.sample1;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//Dao는 Interface로 만든다

//Dept 테이블로 작업할 마이바티스 인터페이스
//Data Access Object: 엔티티로 작업하는 클래스

// 마이바티스 인터페이스: @Mapper, @Select, @Insert, @Update, @Delete
//Mapper: 인터페이스를 스프링 빈으로 등록하는 어노테이션
@Mapper
public interface DeptDao {
	@Select("select deptno from dept")
	public List<Long> findDeptno();

	@Select("select * from dept")
	public List<Dept> findAll();

	// rownum=1 -> 행번호가 1개 -> 즉, 1개 찾았으면 더이상 찾지마(stopkey)
	@Select("select * from dept where deptno=#{deptno} and rownum=1")
	public Dept findByDeptno(Long deptno);

	// insert문의 실행결과는 정수: 추가된 행의 개수를 의미
	@Insert("insert into dept values(#{deptno}, #{dname}, #{loc})")
	public Long save(Dept dept);

	// delete문의 실행결과도 정수: 삭제된 행의 개수를 의미
	@Delete("delete from dept where deptno=#{deptno}")
	public Long delete(Long deptno);
}
