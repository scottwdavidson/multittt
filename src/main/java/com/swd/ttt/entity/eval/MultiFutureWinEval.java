package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;
import com.swd.ttt.entity.heuristic.WinColumnHeuristic;
import com.swd.ttt.entity.heuristic.WinDiagonalHeuristic;
import com.swd.ttt.entity.heuristic.WinRowHeuristic;

import java.util.HashSet;
import java.util.Set;

/**
 * Evaluates a TicTacToe Board and determines if there's a move which could then *lead* to a single row, column or
 * diagnoal win, that is, on a row, column or diagonal is there already an active player's play and two open cells
 * to finish for the win.
 */
public class MultiFutureWinEval implements Eval {

    private WinRowHeuristic winRowHeuristic = new WinRowHeuristic();
    private WinColumnHeuristic winColumnHeuristic = new WinColumnHeuristic();
    private WinDiagonalHeuristic winDiagonalHeuristic = new WinDiagonalHeuristic();

    @Override
    public boolean evaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        // TODO Add a optional circuit break arg to Heuristic moves call for efficiency

        // Use the existing Heuristic classes to do the "dirty" work and count up the number of moves
        Set<Integer> totalMoves = new HashSet<Integer>();
        totalMoves.addAll(winRowHeuristic.moves(tictactoeBoard, activePlayer, opponent));
        totalMoves.addAll(winColumnHeuristic.moves(tictactoeBoard, activePlayer, opponent));
        totalMoves.addAll(winDiagonalHeuristic.moves(tictactoeBoard, activePlayer, opponent));

        return totalMoves.size() >= 2; // TODO this value should be passed in somehow
    }
}
