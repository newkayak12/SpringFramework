package com.kh.spring.board.controller;

import static com.kh.spring.common.PageBar.pageBar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	BoardService service;

	
	
	@RequestMapping("/board/boardlist.do")
	public String boardlist(HttpServletRequest request,Model model, @RequestParam(value="cPage", defaultValue="1") int cPage, @RequestParam(value="numPerPage", defaultValue="5") int numPerPage) {
		
		
		
		int totalData = service.boardCount();
		int pageBarSize = 5;
		
		
		
		
		
		model.addAttribute("list", service.boardlist(cPage,numPerPage));
//		model.addAttribute("pageBar",pageBar(cPage,totalData,numPerPage,pageBarSize,request.getContextPath()+"/board/boardlist.do"));
		model.addAttribute("pageBar",pageBar(cPage,totalData,numPerPage,pageBarSize,"boardlist.do"));
		model.addAttribute("total",totalData);
		
		return "board/boardlist";
	}
	
	@RequestMapping("/board/boarddetail.do")
	public ModelAndView boarddetail(int boardNo, ModelAndView mv ) {
		
		mv.addObject("detail", service.boardDetail(boardNo));
		mv.setViewName("board/boarddetail");
		
		return mv;
	}
	
	@RequestMapping("/board/boardmodify.do")
	public String boardModify(Board board,HttpServletRequest rq) {
		
		service.boardModify(board);
		
		return "redirect:/board/boardlist.do";
	}
	
	@RequestMapping("/board/boardWrite.do")
	public String boardWrite() {
		return "board/boardwrite";
			
	}
	
}
