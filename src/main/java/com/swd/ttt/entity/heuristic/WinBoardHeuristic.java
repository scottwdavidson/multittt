package com.swd.ttt.entity.heuristic;

import java.util.HashSet;
import java.util.Set;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;

public class WinBoardHeuristic extends AbstractSingleHeuristic {
	
	public WinBoardHeuristic(){
		super(Integer.MAX_VALUE);
	}

	/*
	 * Returns the player that won the board, or Player.None if no one has won
	 */
	public Player hasWin(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {		
		
		//1st row mask for X|X|X for active
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000000111, (short) 0b000000111)){
			return activePlayer;
		}
		
		//2nd row mask for X|X|X for active
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000111000, (short) 0b000111000)){
			return activePlayer;
		}
		
		//3rd row mask for X|X|X for active
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000000000, (short) 0b000000000)){
			return activePlayer;
		}
		
		//1st col mask for X|X|X for active
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b001001001, (short) 0b001001001)){
			return activePlayer;
		}
		
		//2nd col mask for X|X|X for active
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b010010010, (short) 0b010010010)){
			return activePlayer;
		}
		
		//3rd col mask for X|X|X for active
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b100100100, (short) 0b100100100)){
			return activePlayer;
		}
		
		//top/left -> bottom/right diagonal for active
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b100010001, (short) 0b100010001)){
			return activePlayer;
		}
		
		//top/right -> bottom/left diagonal for active
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b001010100, (short) 0b001010100)){
			return activePlayer;
		}


		//1st row mask for X|X|X for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000111, (short) 0b000000111)){
			return opponent;
		}

		//2nd row mask for X|X|X for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000111000, (short) 0b000111000)){
			return opponent;
		}

		//3rd row mask for X|X|X for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000000, (short) 0b000000000)){
			return opponent;
		}

		//1st col mask for X|X|X for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b001001001, (short) 0b001001001)){
			return opponent;
		}

		//2nd col mask for X|X|X for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b010010010, (short) 0b010010010)){
			return opponent;
		}

		//3rd col mask for X|X|X for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b100100100, (short) 0b100100100)){
			return opponent;
		}		
		
		//top/left -> bottom/right diagonal for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b100010001, (short) 0b100010001)){
			return opponent;
		}
		
		//top/right -> bottom/left diagonal for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b001010100, (short) 0b100010001)){
			return opponent;
		}

		return Player.None;
	}

	@Override
	public Set<Integer> moves(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {
		// TODO Auto-generated method stub
		return null;
	}

}
