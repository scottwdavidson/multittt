package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.heuristic.*;
import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

import java.util.HashSet;
import java.util.Set;

public class MultiPlayFutureWinEval implements Eval {

    private WinRowHeuristic winRowHeuristic = new WinRowHeuristic();
    private WinColumnHeuristic winColumnHeuristic = new WinColumnHeuristic();
    private WinDiagonalHeuristic winDiagonalHeuristic = new WinDiagonalHeuristic();

    public boolean evaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        // Use the existing Heuristic classes to do the "dirty" work and count up the number of moves
        Set<Integer> totalMoves = new HashSet<Integer>();
        totalMoves.addAll(winRowHeuristic.moves(tictactoeBoard, activePlayer, opponent));
        totalMoves.addAll(winColumnHeuristic.moves(tictactoeBoard, activePlayer, opponent));
        totalMoves.addAll(winDiagonalHeuristic.moves(tictactoeBoard, activePlayer, opponent));

        return totalMoves.size() >= 2;
    }
}
