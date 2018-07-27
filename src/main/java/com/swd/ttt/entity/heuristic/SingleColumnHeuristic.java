package com.swd.ttt.entity.heuristic;

import java.util.Set;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;

public class SingleColumnHeuristic extends AbstractSingleHeuristic {

	private final static int RELATIVE_VALUE = 1;
	
	 public static SingleColumnHeuristic newSingleColumnHeuristic(){
	        return new SingleColumnHeuristic(RELATIVE_VALUE);
	    }
	
	
	@Override
	public Set<Integer> moves(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {
		// TODO Auto-generated method stub
		return null;
	}

    private SingleColumnHeuristic(int relativeValue) {
        super(relativeValue);

    }
	
}
