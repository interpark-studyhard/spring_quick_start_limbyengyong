package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

    public static void main(String[] args) {
        AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
        
        BoardService boardService = (BoardService) container.getBean("boardService");
        
        BoardVO vo = new BoardVO();
        vo.setTitle("테스트 제목");
        vo.setWriter("테스터");
        vo.setContent("가나다라마바사");
        boardService.insertBoard(vo);        
        
        List<BoardVO> boardList = boardService.getBoardList(vo);
        for (BoardVO board : boardList) {
            System.out.println("---> " + board.toString());
        }
        container.close();
    }
}
