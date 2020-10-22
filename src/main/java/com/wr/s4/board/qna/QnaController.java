package com.wr.s4.board.qna;

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
@RequestMapping(value="/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		
		BoardDTO boardDTO = ar.get(0);
		QnaDTO qnaDTO = (QnaDTO)boardDTO;
		System.out.println(qnaDTO.getDepth());
		mv.addObject("board", "qna");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		System.out.println("qna List");
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/boardWirte");
		mv.addObject("board", "qna");
		return mv;
		
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setInsert(boardDTO);
		String message = "Write Fail";
		if(result >0) {
			message = "Write Sucess";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		
		mv.setViewName("common/result");
		return mv;
	}
}
