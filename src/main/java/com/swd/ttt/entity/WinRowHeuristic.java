package com.swd.ttt.entity;

import java.util.HashSet;
import java.util.Set;

public class WinRowHeuristic extends AbstractSingleHeuristic {
	
	public WinRowHeuristic(){
		super(3);
	}

	@Override
	public Set<Integer> moves(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {
		
		
		Set<Integer> moves = new HashSet<Integer>();
		
		// mask for X|X|_ for X
		int currentMove = 2;
		short maskActive = (short) (Math.pow(2, 0) + Math.pow(2, 1) + Math.pow(2, 2));
		short expectedPostMaskActive = (short) (Math.pow(2, 0) + Math.pow(2, 1));
		
		//mask for ?|?|_ for O
		short maskOpponent = (short) (Math.pow(2, 3));
		short expectedPostMaskOpponent = 0;
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), maskActive, expectedPostMaskActive) && 
				mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), maskOpponent, expectedPostMaskOpponent)){
			moves.add(currentMove);
		}
		
		return moves;
	}

}
