package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
	@Autowired
	private InsaDao insaDao;

	public void insa(Integer year) {
		LocalDate startDay = LocalDate.of(year, 1, 1);
		LocalDate endDay = LocalDate.of(year, 12, 31);
		insaDao.insa(startDay, endDay);
	}
}
