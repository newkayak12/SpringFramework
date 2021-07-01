package com.kh.spring.board.controller;

import static com.kh.spring.common.PageBar.pageBar;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Attachment;
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
	
//		requestmapping을 하겠죠?? 일반적으로 그냥 페이지 전환용 그,... 그 페이지 전환용 메소드는 그냥 String으로 반환하는게 편하겠죠 
//		그럼 boardForm이라고 할까요.. return boardform 그럼 이쪽으로 페이지가 전환이 되는거죠
	}
	
	
	
//	07.01
	
	
	@RequestMapping("/board/insertBoard.do")
//	realpath를 받으려고 httpServletRequest를 선언해요
	public ModelAndView boardInsert(HttpServletRequest req,Board board, ModelAndView mv, @RequestParam(value="upFile", required = false)MultipartFile[] upFile ) {
//		board로 받는 이유가 view에서 선언한 내용이 vo 객체 member랑 맞춰놨어요...
//		파일을 받아야겠죠.. 흠.. 객체에 MultipartFile이라는 객체가 있어요 거기에다 upfile이라고 한다구요
			
				log.info( "파일명 "+ upFile[0].getOriginalFilename());
				log.info( "파일 크기{}",upFile[0].getSize());
				log.info( "파일명 "+ upFile[1].getOriginalFilename());
				log.info( "파일 크기{}",upFile[1].getSize());
				
//			MutlipartFile 객체에 있는 녀석들을 찍어보기 size는 int 니까...
//			추가적으로 IO에 있는 걸 bean으로 등록해줘야 알아서 돌아가겠지요?? Servlet context로 갈꼐요
//		여러 개는 그냥 배열로 받으면 됩니다.
//		
		
//		cos로 할 때는 경로 지정하고 알아서 저장했죠.. 이번에는 그렇게 안된다구요!
//		그럼 실질적으로 객체에서 binary를 받아서 저장해야겠죠??
		
//		저장 경로를 설정해야해요! 실제 경로를 가져와야해요! > 가상 경로가 아니라 디렉토리부터 가져와야해요 context에서 getRealpath로요
		String path = req.getServletContext().getRealPath("/resources/upload/board/");

//		board.setAttachment(new Attachment().setOriginalFileName(path));
		List<Attachment> attaches = new ArrayList<>();
		
		
		
		File dir = new File(path);
		
				if(!dir.exists()) {
					dir.mkdirs();
					
//					폴더가 없다면 생성 , mkdirs는 디렉토리까지 생성된다.
				} 
				
			//업로드 처리하기 (다중 _ for로 반복처리하겠죠?)
				
				for(MultipartFile f : upFile) {
					 
					
					if(!f.isEmpty()) {
//						isEmpty 있으면 false 없으면 true
//						!isEmpty >> 결국 파일이 있으면 true가 나오겠죠
						
						String originalFileName=f.getOriginalFilename();
						String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
//						파일이름 파일.exe에서 '.'이후만 남겨놔야...확장자를 살리겠죠??
						
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
						int ranNum = (int)(Math.random()*100000);
						String reName  = sdf.format(System.currentTimeMillis())+"_"+ranNum+ext;
						Attachment attach = Attachment.builder().originalFileName(f.getOriginalFilename()).renamedFileName(reName).build();
						
							attaches.add(attach);
//						파일을 업로드하기!
					
							try {
								f.transferTo(new File(path+reName));
//								이 메소드는 output Stream으로 byte로 날리는거랑 다를 바가 없어요
//								path + 새로 명명된 파일 이름으로 저장이 됩니다.
								
							} catch(IOException e) {
								e.printStackTrace();
							}
					}
					
				}
//			for문 끝...
		
		
		
		
		board.setAttachment(attaches);
		String msg = "등록 성공";
//		mv.setViewName("redirect:/board/boardlist.do");
		try {
			
			service.boardInsert(board);
		} catch(RuntimeException e) {
			 msg = "등록 실패";
		}
		
		mv.addObject("loc", "/board/boardlist.do");
		mv.addObject("msg", msg);
		mv.setViewName("common/message");
		
		return mv;
	}
	
	
	@RequestMapping("/board/fileDownload.do")
	public void fileDownload(@RequestParam(value="oriname") String oriname, @RequestParam(value="rename") String rename, HttpServletResponse resp, HttpServletRequest rqst, @RequestHeader(value="user-agent") String header) {
		
		
		String path = rqst.getServletContext().getRealPath("/resources/upload/board/");
		File saveFile = new File(path+rename);
		
		BufferedInputStream bis = null;
		ServletOutputStream sos = null;
		
			try {
				bis = new BufferedInputStream(new FileInputStream(saveFile));
				sos = resp.getOutputStream();
				boolean isMS = header.indexOf("Trident")!=-1||header.indexOf("MSIE")!=-1;
				String encodeStr = "";
				
				
					if(isMS) {
						encodeStr = URLEncoder.encode(oriname,"UTF-8");
						encodeStr = encodeStr.replaceAll("\\", "%20");
						
					} else {
						
						encodeStr = new String(oriname.getBytes("UTF-8"), "ISO-8859-1");
						
					}
					
					resp.setContentType("application/octet-stream;charset=utf-8");
					
					resp.setHeader("Content-Disposition", "attachment;filename=\""+encodeStr+"\"");
				
					int read = -1;
						while((read = bis.read()) !=-1) {
							
							sos.write(read);
						}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
					try {
						
							bis.close();
							sos.close();
							
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		
	}
}
