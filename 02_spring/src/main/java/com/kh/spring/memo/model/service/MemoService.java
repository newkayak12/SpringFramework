package com.kh.spring.memo.model.service;

import java.util.List;

import com.kh.spring.memo.model.vo.Memo;

public interface MemoService {

	
	public Memo viewMemo(int memoNo, String password);
	public int insertMemo(Memo memo);
	public List<Memo> listMemo();
	public int deleteMemo(int no);
	public String selectPw(int no);
}
