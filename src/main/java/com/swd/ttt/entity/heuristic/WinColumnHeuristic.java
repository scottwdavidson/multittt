package com.swd.ttt.entity.heuristic;

import java.util.HashSet;
import java.util.Set;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;

public class WinColumnHeuristic extends AbstractSingleHeuristic {
	
	public WinColumnHeuristic(){
		super(5);
	}

	@Override
	public Set<Integer> moves(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {
		
		
		Set<Integer> moves = new HashSet<Integer>();
		
		//1st column mask for X|X|_ for active, mask for ?|?|_ for opponent (left -> right = top -> bottom)
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b001001001, (short) 0b000001001) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b001000000, (short) 0b000000000)){
			moves.add(6);
		}
		
		//1st column mask for X|_|X for active, mask for ?|_|? for opponent (left -> right = top -> bottom)
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b001001001, (short) 0b001000001) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000001000, (short) 0b000000000)){
			moves.add(3);
		}
		
		//1st column mask for _|X|X for active, mask for _|?|? for opponent (left -> right = top -> bottom)
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b001001001, (short) 0b001001000) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000001, (short) 0b000000000)){
			moves.add(0);
		}
		
		
		
		//2nd column mask for X|X|_ for active, mask for ?|?|_ for opponent (left -> right = top -> bottom)
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b010010010, (short) 0b000010010) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b010000000, (short) 0b000000000)){
			moves.add(7);
		}
				
		//2nd column mask for X|_|X for active, mask for ?|_|? for opponent (left -> right = top -> bottom)
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b010010010, (short) 0b010000010) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000010000, (short) 0b000000000)){
			moves.add(4);
		}
		
		//2nd column mask for _|X|X for active, mask for _|?|? for opponent (left -> right = top -> bottom)
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b010010010, (short) 0b010010000) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000010, (short) 0b000000000)){
			moves.add(1);
		}
		
		
		
		//3rd column mask for X|X|_ for active, mask for ?|?|_ for opponent (left -> right = top -> bottom)
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b100100100, (short) 0b000100100) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b100000000, (short) 0b000000000)){
			moves.add(8);
		}
				
		//3rd column mask for X|_|X for active, mask for ?|_|? for opponent (left -> right = top -> bottom)
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b100100100, (short) 0b100000100) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000100000, (short) 0b000000000)){
			moves.add(5);
		}
		
		//3rd column mask for _|X|X for active, mask for _|?|? for opponent (left -> right = top -> bottom)
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b100100100, (short) 0b100100000) && 
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000100, (short) 0b000000000)){
			moves.add(2);
		}
		
		
		return moves;
	}

}
