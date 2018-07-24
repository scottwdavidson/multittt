package com.swd.ttt.entity.heuristic;

import java.util.HashSet;
import java.util.Set;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;

// TODO This is symmetric to WinRowHeuristic ( via player ) - look into abstraction to reduce/reuse
public class BlockWinRowHeuristic extends AbstractSingleHeuristic {

	public BlockWinRowHeuristic(){
		super(4);
	}

	@Override
	public Set<Integer> moves(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {
		
		
		Set<Integer> moves = new HashSet<Integer>();
		
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000111, (short) 0b000000011) &&
				mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000000100, (short) 0b000000000)){
			moves.add(2);
		}
		
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000111, (short) 0b000000101) &&
				mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000000010, (short) 0b000000000)){
			moves.add(1);
		}
		
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000111, (short) 0b000000110) &&
				mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000000001, (short) 0b000000000)){
			moves.add(0);
		}
		

		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000111000, (short) 0b000011000) &&
				mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000100000, (short) 0b000000000)){
			moves.add(5);
		}
				
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000111000, (short) 0b000101000) &&
				mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000010000, (short) 0b000000000)){
			moves.add(4);
		}
		
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000111000, (short) 0b000110000) &&
				mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b000001000, (short) 0b000000000)){
			moves.add(3);
		}
		
		
		
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b111000000, (short) 0b011000000) &&
				mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b100000000, (short) 0b000000000)){
			moves.add(8);
		}
				
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b111000000, (short) 0b101000000) &&
				mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b010000000, (short) 0b000000000)){
			moves.add(7);
		}
		
		if(mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b111000000, (short) 0b110000000) &&
				mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b001000000, (short) 0b000000000)){
			moves.add(6);
		}
		
		
		return moves;
	}

}
