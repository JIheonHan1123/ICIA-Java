package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NewBoardDao;
import com.example.demo.entity.NewBoard;

@Service
public class NewBoardService {
	@Autowired
	private NewBoardDao newBoardDao;

	public Boolean write(NewBoard newboard) {
		return newBoardDao.write(newboard) == 1L;
	}
}
