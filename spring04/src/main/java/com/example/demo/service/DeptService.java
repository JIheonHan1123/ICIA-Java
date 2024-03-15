package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DeptDao;
import com.example.demo.dao.EmpDao;
import com.example.demo.entity.Dept;
import com.example.demo.entity.Emp;

@Service
public class DeptService {
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private EmpDao empDao;

	// 부서와 그 부서에 속한 사원 정보를 출력
	public Map<String, Object> read(Long deptno) {
		Dept dept = deptDao.findByDeptno(deptno);
		List<Emp> emps = empDao.findByDeptno(deptno);

		Map<String, Object> map = new HashMap<>();
		map.put("dept", dept);
		map.put("emps", emps);
		return map;
	}
}
