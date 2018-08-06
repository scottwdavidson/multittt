package com.swd.ttt.dao;

import com.swd.ttt.service.BoardDao;
import com.swd.ttt.service.BoardIdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoBoardIdDao implements BoardIdDao {

    private final static int INITIAL_BOARD_ID = 1000;

    @Autowired
    private BoardIdRepository boardIdRepository;


    @Override
    public int current() {
        List<BoardId> boardIds = boardIdRepository.findAll();
        if ( boardIds == null || boardIds.isEmpty() ){
            return INITIAL_BOARD_ID;
        }
        else {
            return boardIds.get(0).getBoardId();
        }
    }

    @Override
    public int increment() {
        BoardId currentBoardId = boardIdRepository.findAll().get(0);
        BoardId updatedBoardId = new BoardId();
        updatedBoardId.setBoardId(currentBoardId.getBoardId() + 1);
        updatedBoardId = this.boardIdRepository.save(updatedBoardId);
        return updatedBoardId.getBoardId();
    }
}
