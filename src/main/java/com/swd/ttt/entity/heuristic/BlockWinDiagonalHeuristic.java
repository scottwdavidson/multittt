package com.swd.ttt.entity.heuristic;

import java.util.Set;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;

public class BlockWinDiagonalHeuristic extends AbstractSingleHeuristic {

	private final static int RELATIVE_VALUE = 4;
	
	 public static BlockWinDiagonalHeuristic newBlockWinDiagonalHeuristic(){
	        return new BlockWinDiagonalHeuristic(RELATIVE_VALUE);
	    }
	
	
	@Override
	public Set<Integer> moves(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {
		// TODO Auto-generated method stub
		return null;
	}

    private BlockWinDiagonalHeuristic(int relativeValue) {
        super(relativeValue);

    }
	
}
