package com.swd.ttt.entity.heuristic;

import java.util.HashSet;
import java.util.Set;

import java.util.Arrays;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

/**
 * Provides a minimal subset of initial moves for performance against sparsely populated TTTBoards
 * @author dylan
 *
 */

public class MinimizeInitialMovesHeuristic extends AbstractSingleHeuristic {
	
	private final static Set<Integer> CORNERS_AND_CENTER = new HashSet<>(Arrays.asList(0, 2, 4, 6, 8));
	//TODO autowire
	private SingleRowHeuristic singleRowHeuristic = SingleRowHeuristic.newSingleRowHeuristic();
    private SingleColumnHeuristic singleColumnHeuristic = SingleColumnHeuristic.newSingleColumnHeuristic();
    private SingleDiagonalHeuristic singleDiagonalHeuristic = SingleDiagonalHeuristic.newSingleDiagonalHeuristic();
	
	public MinimizeInitialMovesHeuristic(){
		super(5);
	}

	@Override
	public Set<Integer> moves(TicTacToeBoard tictactoeBoard,
			Player activePlayer, Player opponent) {
		
		Set<Integer> moves = new HashSet<Integer>();
		Set<Integer> activePlayedMoves = tictactoeBoard.playedMoves(activePlayer);
		Set<Integer> opponentPlayedMoves = tictactoeBoard.playedMoves(opponent);
		
		
		
		//Board is completely empty - return corners and center
		if(activePlayedMoves.isEmpty() && opponentPlayedMoves.isEmpty()){
			return CORNERS_AND_CENTER;
		}
		
		//Board has one activePlayer move and 0 opponent moves
		if(activePlayedMoves.size() == 1 && opponentPlayedMoves.isEmpty()){
			Set<Integer> workingSet = singleRowHeuristic.moves(tictactoeBoard, activePlayer, opponent);
			workingSet.addAll(singleColumnHeuristic.moves(tictactoeBoard, activePlayer, opponent));
			workingSet.addAll(singleDiagonalHeuristic.moves(tictactoeBoard, activePlayer, opponent));
			workingSet.retainAll(CORNERS_AND_CENTER);
			return workingSet;
		}
		
		//Board has 0 activePlayer moves and 1 opponent move
		if(activePlayedMoves.isEmpty() && opponentPlayedMoves.size() == 1){
			Set<Integer> workingSet = singleRowHeuristic.moves(tictactoeBoard, opponent, activePlayer);
			workingSet.addAll(singleColumnHeuristic.moves(tictactoeBoard, opponent, activePlayer));
			workingSet.addAll(singleDiagonalHeuristic.moves(tictactoeBoard, opponent, activePlayer));
			workingSet.retainAll(CORNERS_AND_CENTER);
			return workingSet;
		}
		
		return moves;
	}
	

}
