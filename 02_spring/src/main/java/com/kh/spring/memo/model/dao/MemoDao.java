package com.kh.spring.memo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.memo.model.vo.Memo;

public interface MemoDao {

	public int insertMemo(Memo memo, SqlSessionTemplate sqlSession);
	public List<Memo> listMemo(SqlSessionTemplate sqlSession);
	public int deleteMemo(int no,SqlSessionTemplate sqlSession);
	public String selectPw(int no,  SqlSessionTemplate sqlSession);
}
