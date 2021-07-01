package com.kh.spring.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;
@Repository
public class BoardDaoImpl implements BoardDao {

	@Override
	public List<Board> boardlist( int cPage, int numPerPage, SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		
		return session.selectList("board.boardlist",null,new RowBounds( ((cPage-1)*numPerPage), numPerPage) );
	}

	@Override
	public int boardCount(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectOne("board.boardCount");
	}

	@Override
	public Board boardDetail(SqlSessionTemplate session,int boardNo) {
		// TODO Auto-generated method stub
		session.update("board.readcount", boardNo);
		return session.selectOne("board.boarddetail", boardNo);
	}

	@Override
	public int boardModify(SqlSessionTemplate session, Board board) {
		// TODO Auto-generated method stub
		return session.update("board.boardModify",board);
	}

	@Override
	public int boardInsert(SqlSessionTemplate session, Board board) {
		// TODO Auto-generated method stub
		int bo=	session.insert("board.boardInsert", board);
		
			
			
		return bo;
	}

	@Override
	public int attachmentInsert(SqlSessionTemplate session, Attachment attachment) {
		// TODO Auto-generated method stub
		return session.insert("board.boardAttach", attachment);
	}


}
