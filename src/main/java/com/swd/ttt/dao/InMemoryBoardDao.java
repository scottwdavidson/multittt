package com.swd.ttt.dao;

import java.util.List;

import com.swd.ttt.entity.play.Board;
import com.swd.ttt.service.BoardDao;


public class InMemoryBoardDao implements BoardDao {
	
	private List<Board> boardList;
	private InMemoryBoardIdDao boardIdDao;//Unsure if this should be in here / how the boardID factors in/is different from board.getID()

    @Override
    public void persist(Board board) {
    	boardList.add(board);
    	boardIdDao.increment();//Unsure if this should be here
    	//Also unsure if I need to use com.swd.ttt.entity.play.Board and DOFactory or not here
    }

    @Override
    public Board retrieve(int id) {
        for(Board board : boardList){
        	if(board.getId() == id){
        		return board;
        	}
        }
        return null;
    }

    @Override
    public int latestMoveNumber(int id) {
    	if(boardList.isEmpty()) return -1;
        return boardList.get(boardList.size()-1).getMoveNumber();
    }
}
