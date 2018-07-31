package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

public class WinEval implements Eval {

	@Override
	public boolean evaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

		//1st row mask for X|X|X for active
		if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000000111, (short) 0b000000111)){
			return true;
		}
		
		//2nd row mask for X|X|X for active
		if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000111000, (short) 0b000111000)){
			return true;
		}
		
		//3rd row mask for X|X|X for active
		if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b111000000, (short) 0b111000000)){
			return true;
		}
		
		//1st col mask for X|X|X for active
		if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b001001001, (short) 0b001001001)){
			return true;
		}
		
		//2nd col mask for X|X|X for active
		if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b010010010, (short) 0b010010010)){
			return true;
		}
		
		//3rd col mask for X|X|X for active
		if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b100100100, (short) 0b100100100)){
			return true;
		}
		
		//top/left -> bottom/right diagonal for active
		if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b100010001, (short) 0b100010001)){
			return true;
		}
		
		//top/right -> bottom/left diagonal for active
		if(MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b001010100, (short) 0b001010100)){
			return true;
		}

		return false;
	}


}
