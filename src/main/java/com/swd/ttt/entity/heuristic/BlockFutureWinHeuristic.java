package com.swd.ttt.entity.heuristic;

import java.util.HashSet;
import java.util.Set;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;

public class BlockFutureWinHeuristic extends AbstractSingleHeuristic {
	
	public BlockFutureWinHeuristic(){
		super(0);
	}

	@Override
	public Set<Integer> moves(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {
		
		
		Set<Integer> moves = new HashSet<Integer>();
		
		
		
		
		return moves;
	}

}
