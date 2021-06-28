package com.kh.spring.memo.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.memo.model.dao.MemoDao;
import com.kh.spring.memo.model.vo.Memo;

@Service
public class MemoServiceImpl implements MemoService {
	@Autowired
	MemoDao dao;
	
	@Autowired
	SqlSessionTemplate session;
	
	
	@Override
	public Memo viewMemo(int memoNo, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMemo(Memo memo) {
		// TODO Auto-generated method stub
		return dao.insertMemo(memo, session);
	}


	@Override
	public List<Memo> listMemo() {
		// TODO Auto-generated method stub
		return dao.listMemo(session);
	}

	@Override
	public int deleteMemo(int no) {
		// TODO Auto-generated method stub
		return dao.deleteMemo(no,session);
	}

	@Override
	public String selectPw(int no) {
		// TODO Auto-generated method stub
		return dao.selectPw(no, session);
	}

}
