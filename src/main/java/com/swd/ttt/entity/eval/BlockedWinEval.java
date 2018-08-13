package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;
import com.swd.ttt.entity.heuristic.BlockedWinColumnHeuristic;
import com.swd.ttt.entity.heuristic.BlockedWinDiagonalHeuristic;
import com.swd.ttt.entity.heuristic.BlockedWinRowHeuristic;
import com.swd.ttt.entity.heuristic.SingleColumnHeuristic;
import com.swd.ttt.entity.heuristic.SingleDiagonalHeuristic;
import com.swd.ttt.entity.heuristic.SingleRowHeuristic;

/**
 * Evaluates a TicTacToe Board and determines if there's a move which could then *lead* to a single row, column or
 * diagnoal win, that is, on a row, column or diagonal is there already an active player's play and two open cells
 * to finish for the win.
 */
public class BlockedWinEval implements Eval {

    private BlockedWinColumnHeuristic blockedWinColumnHeuristic = new BlockedWinColumnHeuristic();
    private BlockedWinDiagonalHeuristic blockedWinDiagonalHeuristic = new BlockedWinDiagonalHeuristic();
    private BlockedWinRowHeuristic blockedWinRowHeuristic = new BlockedWinRowHeuristic();

    @Override
    public boolean evaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        // Use the existing Heuristic classes to do the "dirty" work
        // TODO Add a optional circuit break arg to Heuristic moves call for efficiency
        if (!blockedWinColumnHeuristic.moves(tictactoeBoard, activePlayer, opponent).isEmpty()) {
            return true;
        } else if (!blockedWinDiagonalHeuristic.moves(tictactoeBoard, activePlayer, opponent).isEmpty()) {
            return true;
        } else if (!blockedWinRowHeuristic.moves(tictactoeBoard, activePlayer, opponent).isEmpty()) {
            return true;
        }
        return false;
    }
}
