package com.swd.ttt.entity;

import com.swd.ttt.entity.TicTacToeBoard.Cell;

/**
 * Represents the function of executing a "turn" in the game, collecting all of the intrinsic
 * required actions into a single place. The input is a MovePosition and a Board and the output is the
 * *next* Board with the provided move executed.
 */
public class Turn {

    public static Board executeTurn(MovePosition movePosition,final Board board){

        // TODO Dylan to implement
    	
    	//initializing new board w/ arg board data
    	Board newBoard = new Board();
    	newBoard.setActivePlayer(board.getActivePlayer());
    	newBoard.setGameState(board.getGameState());
    	newBoard.setWinningPlayer(board.getWinningPlayer());
    	newBoard.setTttBoards(board.getTttBoards());

    	//make move
    	TicTacToeBoard[] tttBoards = newBoard.getTttBoards();
    	TicTacToeBoard currentTttBoard = tttBoards[movePosition.getTicTacToeBoardIndex()];
    	if(board.getActivePlayer() == Player.X){
    		currentTttBoard.getCells()[movePosition.getPosition()] = Cell.X_CELL;
    	}else{
    		currentTttBoard.getCells()[movePosition.getPosition()] = Cell.O_CELL;
    	}
    	tttBoards[movePosition.getTicTacToeBoardIndex()] = currentTttBoard;
    	
    	//change which tttboard is the activeBoard
    	tttBoards[movePosition.getTicTacToeBoardIndex()].setActive(false);
    	tttBoards[movePosition.getPosition()].setActive(true);
    	
    	//put updtated tttBoards into new Board
    	newBoard.setTttBoards(tttBoards);
    	
    	//flip active player
    	newBoard.setActivePlayer(newBoard.getActivePlayer().opponent());
    	
    	//check for local tttboard win & whole game win here?
    	//does new board get a new id?
    	
        return newBoard;
    }
}
