package com.swd.ttt.dao;

import com.swd.ttt.service.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

        Optional<Board> optionalBoard = this.boardRepository.findById(Integer.valueOf(id));
        if ( optionalBoard.isPresent() ){
            return EntityFactory.generateBoardEntity(optionalBoard.get());
        }
        return null;
    }
}
