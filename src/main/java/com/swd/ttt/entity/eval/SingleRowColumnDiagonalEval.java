package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;
import com.swd.ttt.entity.heuristic.SingleColumnHeuristic;
import com.swd.ttt.entity.heuristic.SingleDiagonalHeuristic;
import com.swd.ttt.entity.heuristic.SingleRowHeuristic;

/**
 * Evaluates a TicTacToe Board and determines if there's a move which could then *lead* to a single row, column or
 * diagnoal win, that is, on a row, column or diagonal is there already an active player's play and two open cells
 * to finish for the win.
 */
public class SingleRowColumnDiagonalEval implements Eval {

    private SingleRowHeuristic singleRowHeuristic = SingleRowHeuristic.newSingleRowHeuristic();
    private SingleColumnHeuristic singleColumnHeuristic = SingleColumnHeuristic.newSingleColumnHeuristic();
    private SingleDiagonalHeuristic singleDiagonalHeuristic = SingleDiagonalHeuristic.newSingleDiagonalHeuristic();

    @Override
    public boolean evaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        // Use the existing Heuristic classes to do the "dirty" work
        // TODO Add a optional circuit break arg to Heuristic moves call for efficiency
        if (!singleRowHeuristic.moves(tictactoeBoard, activePlayer, opponent).isEmpty()) {
            return true;
        } else if (!singleColumnHeuristic.moves(tictactoeBoard, activePlayer, opponent).isEmpty()) {
            return true;
        } else if (!singleDiagonalHeuristic.moves(tictactoeBoard, activePlayer, opponent).isEmpty()) {
            return true;
        }
        return false;
    }
}
