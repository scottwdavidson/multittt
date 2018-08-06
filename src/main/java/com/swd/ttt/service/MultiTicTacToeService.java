package com.swd.ttt.service;

import com.swd.ttt.Service;
import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MultiTicTacToeService implements Service {

    @Autowired
    BoardDao boardDao;

    @Override
    public Board move(String boardId, String player, int tictactoeBoardIndex, int boardPosition) {
        Board board = Board.initialBoard(1000, Player.X, 4);
        return board;
    }

    public Board generateBoardForTest() {

        Board board = Board.initialBoard(1000, Player.X, 4);
        return board;
    }

    public Board newGame(int activeTicTacToeBoard){
        Board board = Board.initialBoard(1000, Player.X, activeTicTacToeBoard);
        this.boardDao.persist(board);
        return board;
    }

}
