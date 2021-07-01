package com.kh.spring.board.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;
	@Autowired
	SqlSessionTemplate session;
	
	
	@Override
	public List<Board> boardlist(int cPage, int numPerPage) {
		return dao.boardlist( cPage, numPerPage, session);
	}


	@Override
	public int boardCount() {
		return dao.boardCount(session);
	}


	@Override
	public Board boardDetail(int boardNo) {
		
		Board board = dao.boardDetail(session, boardNo);
			
		return  board;
	}


	@Override
	public int boardModify(Board board) {
		return dao.boardModify(session, board);
	}


	@Override
//	@Transactional
	
	public int boardInsert(Board board) throws RuntimeException {
		
		int bo =dao.boardInsert(session, board);
		int result = 0;
		log.debug("{}",board.getBoardNo());
			if(bo>0) {
						
						if(board.getAttachment().size()>0) {
						
							try {
								for(Attachment a :board.getAttachment()) {
									a.setBoardNo(board.getBoardNo());
									result += dao.attachmentInsert(session, a);
								}
							}catch(RuntimeException e) {
								throw new RuntimeException("실패");
							}
						}
					}
		return bo+result;
	}

}
