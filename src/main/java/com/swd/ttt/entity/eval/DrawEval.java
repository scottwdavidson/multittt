package com.swd.ttt.entity.eval;

import java.util.HashSet;
import java.util.Set;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;
import com.swd.ttt.entity.heuristic.AbstractSingleHeuristic;

public class DrawEval extends AbstractSingleHeuristic {
	
	public DrawEval(){
		super(0);
	}

	public boolean hasDraw(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {		
		
		boolean isDraw = true;
		
		if(!(hasPlayerInRow(1, tictactoeBoard, activePlayer) && hasPlayerInRow(1, tictactoeBoard, opponent))){
			isDraw = false;
		}else if(!(hasPlayerInRow(2, tictactoeBoard, activePlayer) && hasPlayerInRow(2, tictactoeBoard, opponent))){
			isDraw = false;
		}else if(!(hasPlayerInRow(3, tictactoeBoard, activePlayer) && hasPlayerInRow(3, tictactoeBoard, opponent))){
			isDraw = false;
		}else if(!(hasPlayerInColumn(1, tictactoeBoard, activePlayer) && hasPlayerInColumn(1, tictactoeBoard, opponent))){
			isDraw = false;
		}else if(!(hasPlayerInColumn(2, tictactoeBoard, activePlayer) && hasPlayerInColumn(2, tictactoeBoard, opponent))){
			isDraw = false;
		}else if(!(hasPlayerInColumn(3, tictactoeBoard, activePlayer) && hasPlayerInColumn(3, tictactoeBoard, opponent))){
			isDraw = false;
		}else if(!(hasPlayerInDiagonal(true, tictactoeBoard, activePlayer) && hasPlayerInDiagonal(true, tictactoeBoard, opponent))){
			isDraw = false;
		}else if(!(hasPlayerInDiagonal(false, tictactoeBoard, activePlayer) && hasPlayerInDiagonal(false, tictactoeBoard, opponent))){
			isDraw = false;
		}

		return isDraw;
	}
	
	public boolean hasPlayerInRow(int row, TicTacToeBoard tictactoeBoard, Player player){
		if(row == 1){
			if(mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000000111, (short) 0b000000001) || 
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000000111, (short) 0b000000010) ||
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000000111, (short) 0b000000100)){
				return true;
			}
		}else if(row == 2){
			if(mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000111000, (short) 0b000001000) || 
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000111000, (short) 0b000010000) ||
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000111000, (short) 0b000100000)){
				return true;
			}
		}else if(row == 3){
			if(mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b111000000, (short) 0b001000000) || 
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b111000000, (short) 0b010000000) ||
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b111000000, (short) 0b100000000)){
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPlayerInColumn(int col, TicTacToeBoard tictactoeBoard, Player player){
		if(col == 1){
			if(mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b001001001, (short) 0b000000001) || 
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b001001001, (short) 0b000001000) ||
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b001001001, (short) 0b001000000)){
				return true;
			}
		}else if(col == 2){
			if(mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b010010010, (short) 0b000000010) || 
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b010010010, (short) 0b000010000) ||
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b010010010, (short) 0b010000000)){
				return true;
			}
		}else if(col == 3){
			if(mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b100100100, (short) 0b000000100) || 
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b100100100, (short) 0b000100000) ||
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b100100100, (short) 0b100000000)){
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPlayerInDiagonal(boolean topLeftBottomRight, TicTacToeBoard tictactoeBoard, Player player){
		if(topLeftBottomRight == true){
			if(mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b100010001, (short) 0b000000001) || 
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b100010001, (short) 0b000010000) ||
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b100010001, (short) 0b100000000)){
				return true;
			}
		}else if(topLeftBottomRight == false){
			if(mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b001010100, (short) 0b000000100) || 
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b001010100, (short) 0b000010000) ||
					mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b001010100, (short) 0b001000000)){
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Integer> moves(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {
		// TODO Auto-generated method stub
		return null;
	}

}
