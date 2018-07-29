package com.swd.ttt.service;

import com.swd.ttt.Service;
import com.swd.ttt.entity.*;
import org.springframework.stereotype.Component;

@Component
public class MultiTicTacToeService implements Service {

    @Override
    public Board move(String boardId, String player, int tictactoeBoardIndex, int boardPosition) {
        return null;
    }

    public Board generateBoardForTest(){

        Board board = new Board();

        board.setId(1000);
        board.setGameState(GameState.Open);
        board.setActivePlayer(Player.O);
        board.setWinningPlayer(Player.None);

        for(int i=0; i<9; i++){
            board.getTttBoards()[i] = TicTacToeBoard.emptyTicTacToeBoard(i);
        }

        board.getTttBoards()[4] = TicTacToeBoard.applyMove(
                board.getTttBoards()[4], Player.X, MovePosition.newMovePosition(4,4),1);

            return board;
    }
}
