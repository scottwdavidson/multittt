package com.swd.ttt.tui;

import com.swd.ttt.entity.Turn;
import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.GameState;
import com.swd.ttt.entity.play.MovePosition;
import com.swd.ttt.entity.play.Player;

/**
 * Game "console" for the Human versus Human, text user interface (TUI) version of the Multi Tic Tac Toe game.
 */
public class HumanVHuman {

    Turn turn = new Turn();

    public static void main(String[] args){

        new HumanVHuman().run(1000, Player.X, 4);

    }

    public void run(int boardId, Player firstPlayer, int firstTicTacToeBoardIndex){

        // Create the Board
        Board board = Board.initialBoard(boardId, firstPlayer,firstTicTacToeBoardIndex);

        // ***********************
        // Game Loop ( Start )
        while (board.getGameState() == GameState.Open){

            // Display current board
            System.out.println(Presentation.presentation(board));

            // Solicit move from active player
            MovePosition movePosition = solicitMove(board);

            // Make the move
            board = turn.executeTurn(movePosition, board);

        }
        // Game Loop ( End )
        // ***********************

        // Print results

    }


    protected MovePosition solicitMove(Board board){
        return null; // TODO DYLAN ...
    }

}
