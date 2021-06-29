package com.kh.spring.board.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Board;
@Service
public class BaordServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;
	@Autowired
	SqlSessionTemplate session;
	
	
	@Override
	public List<Board> boardlist(int cPage, int numPerPage) {
		// TODO Auto-generated method stub
		return dao.boardlist( cPage, numPerPage, session);
	}


	@Override
	public int boardCount() {
		// TODO Auto-generated method stub
		return dao.boardCount(session);
	}


	@Override
	public Board boardDetail(int boardNo) {
		// TODO Auto-generated method stub
		return dao.boardDetail(session, boardNo);
	}


	@Override
	public int boardModify(Board board) {
		// TODO Auto-generated method stub
		return dao.boardModify(session, board);
	}

}
