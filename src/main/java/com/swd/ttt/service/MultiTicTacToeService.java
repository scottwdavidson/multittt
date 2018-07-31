package com.swd.ttt.service;

import com.swd.ttt.Service;
import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.Player;
import org.springframework.stereotype.Component;

@Component
public class MultiTicTacToeService implements Service {

    @Override
    public Board move(String boardId, String player, int tictactoeBoardIndex, int boardPosition) {
        return null;
    }

    public Board generateBoardForTest() {

        Board board = Board.initialBoard(1000, Player.X, 4);
        return board;
    }
}
