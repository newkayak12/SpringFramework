package com.kh.spring.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;

public interface BoardDao {

	public List<Board> boardlist(int cPage, int numPerPage, SqlSessionTemplate session);
	public int boardCount( SqlSessionTemplate session);
	public Board boardDetail(SqlSessionTemplate session, int boardNo);
	public int boardModify(SqlSessionTemplate session, Board board);
	public int boardInsert(SqlSessionTemplate session, Board board);
	public int attachmentInsert(SqlSessionTemplate session, Attachment attachment);
}
