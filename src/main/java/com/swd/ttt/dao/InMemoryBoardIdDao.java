package com.swd.ttt.dao;

import java.util.List;

import com.swd.ttt.service.BoardIdDao;

public class InMemoryBoardIdDao implements BoardIdDao {
	
	private final static int DEFAULT_BOARD_ID = 1000;
	private List<BoardId> boardIdList;

    @Override
    public int current() {
        if(boardIdList.isEmpty()){
        	return -1;
        }else{
        	return boardIdList.get(boardIdList.size()-1).getBoardId();
        }
    }

    @Override
    public int increment() {
    	if(boardIdList.isEmpty()){
    		BoardId firstBoardId = new BoardId();
    		firstBoardId.setBoardId(DEFAULT_BOARD_ID);
    		return firstBoardId.getBoardId();
    	}
        BoardId current = boardIdList.get(boardIdList.size()-1);
        BoardId incrementedBoardId = new BoardId();
        incrementedBoardId.setBoardId(current.getBoardId() + 1);
        boardIdList.add(incrementedBoardId);
        return incrementedBoardId.getBoardId();
    }
}
