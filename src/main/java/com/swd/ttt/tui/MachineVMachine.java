package com.swd.ttt.tui;

import com.swd.ttt.entity.Turn;
import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.GameState;
import com.swd.ttt.entity.play.MovePosition;
import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.strategy.minmax.MinMaxStrategy;

import java.util.Scanner;

/**
 * Game "console" for the Machine versus Machine, text user interface (TUI) version of the Multi Tic Tac Toe game.
 */
public class MachineVMachine {

    Turn turn = new Turn();
    MinMaxStrategy minMaxStrategy = new MinMaxStrategy();

    public static void main(String[] args){

        new MachineVMachine().run(1000, Player.X, 4);

    }

    public void run(int boardId, Player firstPlayer, int firstTicTacToeBoardIndex){

        // Create the Board
        Board board = Board.initialBoard(boardId, firstPlayer,firstTicTacToeBoardIndex);

        // ***********************
        // Game Loop ( Start )
        long machineMoveRuntimeMillis = -1;
        while (board.getGameState() == GameState.Open){

            // Display current board
            System.out.println(Presentation.presentation(board, machineMoveRuntimeMillis));

            
            // Machine move
            long start = System.currentTimeMillis();
            board = minMaxStrategy.executeMove(board);
            long end = System.currentTimeMillis();
            machineMoveRuntimeMillis = end - start;

        }
        // Game Loop ( End )
        // ***********************

        System.out.println(Presentation.presentation(board));
        System.out.println("Player " + board.getScore().winningPlayer() + " Wins the game!");

    }

}
