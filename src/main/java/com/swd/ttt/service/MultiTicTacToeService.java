package com.swd.ttt.service;

import com.swd.ttt.Service;
import com.swd.ttt.dao.BoardId;
import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MultiTicTacToeService implements Service {

    @Autowired
    BoardDao boardDao;

    @Autowired
    BoardIdDao boardIdDao;

    @Override
    public Board newGame(int activeTicTacToeBoard){

        int incrementBoardId = this.boardIdDao.increment();
        Board board = Board.initialBoard(incrementBoardId, Player.X, activeTicTacToeBoard);
        this.boardDao.persist(board);
        return board;
    }

    @Override
    public Board move(String boardId, String player, int tictactoeBoardIndex, int boardPosition) {
        Board board = Board.initialBoard(1000, Player.X, 4);
        return board;
    }

    public Board generateBoardForTest() {

        Board board = Board.initialBoard(1000, Player.X, 4);
        return board;
    }

    @Override
    public Board getLatest(int boardId) {
        Board board = this.boardDao.retrieve(boardId);
        return board;
    }

}
