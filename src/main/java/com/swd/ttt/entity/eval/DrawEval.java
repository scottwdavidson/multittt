package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;

public class DrawEval implements Eval {

	public boolean evaluationMatches(TicTacToeBoard tictactoeBoard,	Player activePlayer, Player opponent) {		
		
		//check to make sure no players have won first
		WinEval winEval = new WinEval();
		if(winEval.evaluationMatches(tictactoeBoard, activePlayer, opponent) || winEval.evaluationMatches(tictactoeBoard, opponent, activePlayer)){
			return false;
		}
		
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
			if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000000001, (short) 0b000000001) || 
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000000010, (short) 0b000000010) ||
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000000100, (short) 0b000000100)){
				return true;
			}
		}else if(row == 2){
			if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000001000, (short) 0b000001000) || 
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000010000, (short) 0b000010000) ||
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000100000, (short) 0b000100000)){
				return true;
			}
		}else if(row == 3){
			if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b001000000, (short) 0b001000000) || 
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b010000000, (short) 0b010000000) ||
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b100000000, (short) 0b100000000)){
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPlayerInColumn(int col, TicTacToeBoard tictactoeBoard, Player player){
		if(col == 1){
			if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000000001, (short) 0b000000001) || 
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000001000, (short) 0b000001000) ||
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b001000000, (short) 0b001000000)){
				return true;
			}
		}else if(col == 2){
			if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000000010, (short) 0b000000010) || 
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000010000, (short) 0b000010000) ||
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b010000000, (short) 0b010000000)){
				return true;
			}
		}else if(col == 3){
			if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000000100, (short) 0b000000100) || 
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000100000, (short) 0b000100000) ||
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b100000000, (short) 0b100000000)){
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPlayerInDiagonal(boolean topLeftBottomRight, TicTacToeBoard tictactoeBoard, Player player){
		if(topLeftBottomRight == true){
			if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000000001, (short) 0b000000001) || 
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000010000, (short) 0b000010000) ||
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b100000000, (short) 0b100000000)){
				return true;
			}
		}else if(topLeftBottomRight == false){
			if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000000100, (short) 0b000000100) || 
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b000010000, (short) 0b000010000) ||
					MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(player), (short) 0b001000000, (short) 0b001000000)){
				return true;
			}
		}
		return false;
	}

}
