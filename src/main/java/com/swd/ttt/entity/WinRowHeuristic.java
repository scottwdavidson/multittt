package com.swd.ttt.entity;

import java.util.HashSet;
import java.util.Set;

public class WinRowHeuristic extends AbstractSingleHeuristic {
	
	public WinRowHeuristic(){
		super(5);
	}

	@Override
	public Set<Integer> moves(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {
		
		
		Set<Integer> moves = new HashSet<Integer>();
		
		//1st row mask for X|X|_ for active, mask for ?|?|_ for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000000111, (short) 0b000000011) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000100, (short) 0b000000000)){
			moves.add(2);
		}
		
		//1st row mask for X|_|X for active, mask for ?|_|? for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000000111, (short) 0b000000101) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000010, (short) 0b000000000)){
			moves.add(1);
		}
		
		//1st row mask for _|X|X for active, mask for _|?|? for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000000111, (short) 0b000000110) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000001, (short) 0b000000000)){
			moves.add(0);
		}
		
		
		
		//2nd row mask for X|X|_ for active, mask for ?|?|_ for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000111000, (short) 0b000011000) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000100000, (short) 0b000000000)){
			moves.add(5);
		}
				
		//2nd row mask for X|_|X for active, mask for ?|_|? for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000111000, (short) 0b000101000) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000010000, (short) 0b000000000)){
			moves.add(4);
		}
		
		//2nd row mask for _|X|X for active, mask for _|?|? for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000111000, (short) 0b000110000) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000001000, (short) 0b000000000)){
			moves.add(3);
		}
		
		
		
		//3rd row mask for X|X|_ for active, mask for ?|?|_ for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b111000000, (short) 0b011000000) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b100000000, (short) 0b000000000)){
			moves.add(8);
		}
				
		//3rd row mask for X|_|X for active, mask for ?|_|? for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b111000000, (short) 0b101000000) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b010000000, (short) 0b000000000)){
			moves.add(7);
		}
		
		//3rd row mask for _|X|X for active, mask for _|?|? for opponent
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b111000000, (short) 0b110000000) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b001000000, (short) 0b000000000)){
			moves.add(6);
		}
		
		
		return moves;
	}

}
