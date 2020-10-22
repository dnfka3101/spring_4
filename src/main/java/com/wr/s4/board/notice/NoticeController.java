package com.wr.s4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wr.s4.board.BoardDTO;
import com.wr.s4.util.Pager;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//@RequestMapping(value = "noticeList")
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList(pager);
		
		mv.addObject("board", "notice");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		System.out.println("Notice List");
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setInsert(boardDTO);
		String message = "Write Fail";
		if(result >0) {
			message = "Write Sucess";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boardDTO= noticeService.getOne(boardDTO);
		mv.addObject("select", boardDTO);
		mv.setViewName("board/boardSelect");
		
		if(boardDTO != null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("dto", boardDTO);
			mv.addObject("board", "notice");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "No Data");
			mv.addObject("path", "./noticeList");
		}
		
		return mv;
	}
	@PostMapping("noticeUpate")
	public ModelAndView setDelete(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setUpdate(boardDTO);
		String message= "Upate 실패!";
		if(result>0) {
			message = "Upate 성공!";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		
		mv.setViewName("common/result");
		
		return mv;
	}
}
