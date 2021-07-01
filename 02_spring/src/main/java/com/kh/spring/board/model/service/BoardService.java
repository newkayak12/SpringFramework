package com.kh.spring.board.model.service;

import java.util.List;

import com.kh.spring.board.model.vo.Board;

public interface BoardService {

	
	public List<Board> boardlist(int cPage, int numPerPage);
	public int boardCount();
	public Board boardDetail(int boardNo);
	public int boardModify(Board board);
	public int boardInsert(Board board);
}
