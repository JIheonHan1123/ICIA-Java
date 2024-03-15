package com.example.demo.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DeptDao;
import com.example.demo.dao.EmpDao;
import com.example.demo.entity.Emp;

@Service
public class EmpService {
	@Autowired
	private EmpDao empDao;
	@Autowired
	private DeptDao deptDao;

	// 사원목록
	public List<Emp> list() {
		return empDao.findAll();
	}

	// 사원조회
	public Emp read(Long empno) {
		return empDao.findByEmpno(empno);
	}

	// 사원 추가를 위한 데이터: 관리자목록, 부서번호목록, job목록
	public Map<String, Object> findAddInfo() {
		List<Long> mgrs = empDao.findMgrs();
		List<Long> deptnos = deptDao.findDeptno();
		List<String> jobs = empDao.findJobs();

		Map<String, Object> addInfo = new HashMap<>();
		addInfo.put("mgrs", mgrs);
		addInfo.put("deptnos", deptnos);
		addInfo.put("jobs", jobs);
		return addInfo;
	}

	// 사원 추가: 사번(백에서 처리)과 입사일(없는 경우 백에서 처리)
	public Boolean add(Emp emp) {
		// 사번
		Long newEmpno = empDao.max() + 1;
		emp.setEmpno(newEmpno);

		// 입사일을 선택하지 않으면 "오늘"
		if (emp.getHiredate() == null) {
			emp.setHiredate(LocalDate.now());
		}

		return empDao.save(emp) == 1L;
	}

	// 사원삭제
	public Boolean delete(Long empno) {
		return empDao.deleteByEmpno(empno) == 1L;
	}
}
