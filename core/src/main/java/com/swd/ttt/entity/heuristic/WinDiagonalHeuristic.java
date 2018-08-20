package com.swd.ttt.entity.heuristic;

import java.util.HashSet;
import java.util.Set;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

public class WinDiagonalHeuristic extends AbstractSingleHeuristic {

	public WinDiagonalHeuristic(){
		super(4);
	}

	@Override
	public Set<Integer> moves(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {
		
		
		Set<Integer> moves = new HashSet<Integer>();

		// Upper Left to Lower Right
		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b100010001, (short) 0b000010001) &&
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b100000000, (short) 0b000000000)){
			moves.add(8);
		}

		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b100010001, (short) 0b100000001) &&
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000010000, (short) 0b000000000)){
			moves.add(4);
		}

		if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b100010001, (short) 0b100010000) &&
				mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000001, (short) 0b000000000)){
			moves.add(0);
		}

        // Upper Right to Lower Left
        if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b001010100, (short) 0b001010000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000000100, (short) 0b000000000)){
            moves.add(2);
        }

        if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b001010100, (short) 0b001000100) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b000010000, (short) 0b000000000)){
            moves.add(4);
        }

        if(mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b001010100, (short) 0b000010100) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b001000000, (short) 0b000000000)){
            moves.add(6);
        }

        return moves;
	}

}
