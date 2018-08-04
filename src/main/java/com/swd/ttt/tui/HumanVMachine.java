package com.swd.ttt.tui;

import com.swd.ttt.entity.Turn;
import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.GameState;
import com.swd.ttt.entity.play.MovePosition;
import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.strategy.minmax.MinMaxStrategy;

import java.util.Scanner;

/**
 * Game "console" for the Human versus Human, text user interface (TUI) version of the Multi Tic Tac Toe game.
 */
public class HumanVMachine {

    Turn turn = new Turn();
    MinMaxStrategy minMaxStrategy = new MinMaxStrategy();

    public static void main(String[] args){

        new HumanVMachine().run(1000, Player.X, 4);

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

            // Solicit move from active player
            MovePosition movePosition = solicitMove(board);

            // Make the move
            board = turn.executeTurn(board, movePosition);

            // Break if necessary
            if ( board.getGameState() == GameState.Closed ){
                break;
            }

            // Display current board
            System.out.println(Presentation.presentation(board));
            
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


    protected MovePosition solicitMove(Board board){
    	System.out.println("Player " + board.getActivePlayer() + ": It is your turn." + "\t\t\tRemember: \t 0 | 1 | 2 ");
    	System.out.println("You must play in board #" + board.getActiveTicTacToeBoardIndex() + ".\t\t\t\t\t---|---|---");
    	System.out.println("Where would you like to play? \t\t\t\t\t 3 | 4 | 5 ");
    	System.out.println("Type the integer for the corresponding cell.\t\t\t---|---|---");
    	System.out.print("Then press 'Enter'.\t\t\t\t\t\t 6 | 7 | 8 " + "\n>");
    	Scanner scanner = new Scanner(System.in);
    	int input = scanner.nextInt();
    	
    	while(input > 8 || input < 0 || board.getTttBoards()[board.getActiveTicTacToeBoardIndex()].getCells()[input].getPlayer() != Player.None){
    		System.out.println("Invalid Selection. Please try again. \n>");
    		input = scanner.nextInt();
    	}
    	
    	MovePosition nextMove = MovePosition.newMovePosition(board.getActiveTicTacToeBoardIndex(), input);
    	
    	
        return nextMove; // TODO DYLAN ...
    }

}
