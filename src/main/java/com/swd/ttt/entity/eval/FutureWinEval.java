package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;
import com.swd.ttt.entity.heuristic.*;

/**
 * Evaluates a TicTacToe Board and determines if there's a move which could then *lead* to a single row, column or
 * diagnoal win, that is, on a row, column or diagonal is there already an active player's play and two open cells
 * to finish for the win.
 */
public class FutureWinEval implements Eval {

    private WinRowHeuristic winRowHeuristic = new WinRowHeuristic();
    private WinColumnHeuristic winColumnHeuristic = new WinColumnHeuristic();
    private WinDiagonalHeuristic winDiagonalHeuristic = new WinDiagonalHeuristic();

    @Override
    public boolean evaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        // Use the existing Heuristic classes to do the "dirty" work
        // TODO Add a optional circuit break arg to Heuristic moves call for efficiency
        if (!winRowHeuristic.moves(tictactoeBoard, activePlayer, opponent).isEmpty()) {
            return true;
        } else if (!winColumnHeuristic.moves(tictactoeBoard, activePlayer, opponent).isEmpty()) {
            return true;
        } else if (!winDiagonalHeuristic.moves(tictactoeBoard, activePlayer, opponent).isEmpty()) {
            return true;
        }
        return false;
    }
}
