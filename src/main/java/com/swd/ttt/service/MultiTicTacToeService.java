package com.swd.ttt.service;

import com.swd.ttt.Service;
import com.swd.ttt.entity.Board;
import com.swd.ttt.entity.GameState;
import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;
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
        board.setGameState(GameState.Open.name());
        board.setActivePlayer(Player.O);
        board.setWinningPlayer(Player.None);

        for(int i=0; i<9; i++){

            TicTacToeBoard tttBoard = TicTacToeBoard.newTicTacToeBoard(GameState.Open.name(),true,Player.None);
            if ( i == 4 ) {
                 tttBoard.getCells()[4] = TicTacToeBoard.Cell.newCell(Player.None.X,4);
            }

            board.getTttBoards()[i] = tttBoard;
        }

        return board;
    }
}
