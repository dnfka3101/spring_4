package com.wr.s4.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wr.s4.MyTestCase;
import com.wr.s4.board.BoardDTO;
import com.wr.s4.util.Pager;

public class QnaDAOTest extends MyTestCase {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void getList() throws Exception{
		Pager pager = new Pager();
		
		pager.makeRow();
		
		List<BoardDTO> ar = qnaDAO.getList(pager);
		assertEquals(10, ar.size());
	}
	
	//@Test
	public void setInsertTest()throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("title test");
		boardDTO.setWriter("writer test");
		boardDTO.setContents("contents test");
		int result = qnaDAO.setInsert(boardDTO);
		assertEquals(1, result);
		
	}

}
