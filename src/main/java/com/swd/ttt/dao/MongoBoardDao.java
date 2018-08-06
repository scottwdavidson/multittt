package com.swd.ttt.dao;

import com.swd.ttt.service.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MongoBoardDao implements BoardDao {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public void persist(com.swd.ttt.entity.play.Board boardEntity) {

        Board boardDO = DOFactory.generateBoardDO(boardEntity);
        boardDO = this.boardRepository.save(boardDO);
    }

    @Override
    public com.swd.ttt.entity.play.Board retrieve(int id) {

        List<Board> boards = this.boardRepository.findByBoardId(Integer.valueOf(id));
        if (boards == null || boards.isEmpty()) {
            return null;
        }

        return EntityFactory.generateBoardEntity(boards.get(boards.size() -1 ));
    }

    @Override
    public int latestMoveNumber(int id){
        List<Board> boards = this.boardRepository.findByBoardId(Integer.valueOf(id));
        if (boards == null || boards.isEmpty()) {
            return -1;
        }

        int highestMoveNumber = -1;
        for(Board board: boards){
            if ( board.getMoveNumber() > highestMoveNumber ){
                highestMoveNumber = board.getMoveNumber();
            }
        }
        return highestMoveNumber;
    }
}
