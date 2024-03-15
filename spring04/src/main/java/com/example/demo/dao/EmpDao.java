package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.LoginDto;
import com.example.demo.entity.Emp;

@Mapper
public interface EmpDao {
	// ename이 아이디고 empno가 비밀번호라면
	// 결과를 boolean으로 내보내기 -> 0이면 거짓, 0이 아니면 참
	@Select("select count(*) from emp where ename=#{username} and empno=#{password} and rownum=1")
	public Boolean findByEnameAndEmpno(LoginDto dto);

	// 사원목록 조회
	@Select("select empno, ename, job, hiredate, deptno from emp")
	public List<Emp> findAll();

	// 사원정보 조회
	@Select("select * from emp where empno=#{empno} and rownum=1")
	public Emp findByEmpno(Long empno);

	// 새로운 사원번호를 만들기 전에 현재 사원번호의 최대값 계산
	@Select("select max(empno) from emp")
	public Long max();

	// insert, delete, update문의 결과는 변경된 행의 개수 -> Long이나 Integer로 받아준다
	@Insert("insert into emp values(#{empno}, #{ename}, #{job}, #{mgr}, #{hiredate}, #{sal}, #{comm, jdbcType=INTEGER}, #{deptno})")
	public Long save(Emp emp);

	// 사원삭제
	@Delete("delete from emp where empno=#{empno} and rownum=1")
	public Long deleteByEmpno(Long empno);

	// 부서조회
	@Select("select * from emp where deptno=#{deptno}")
	public List<Emp> findByDeptno(Long deptno);

	// 업무조회
	@Select("select distinct job from emp")
	public List<String> findJobs();

	@Select("select distinct mgr from emp where mgr is not null")
	public List<Long> findMgrs();
}
