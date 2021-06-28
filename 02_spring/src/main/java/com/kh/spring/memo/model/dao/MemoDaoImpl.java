package com.kh.spring.memo.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.memo.model.vo.Memo;

@Repository
public class MemoDaoImpl implements MemoDao {

	@Override
	public int insertMemo(Memo memo, SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.insert("memo.insertMemo", memo);
	}

	@Override
	public List<Memo> listMemo(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("memo.listMemo");
	}

	@Override
	public int deleteMemo(int no, SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		return sqlSession.delete("memo.deleteMemo",no);
	}

	@Override
	public String selectPw(int no, SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("memo.selectPw",no);
	}

}
