package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.heuristic.FutureWinHeuristic;
import com.swd.ttt.entity.heuristic.WinColumnHeuristic;
import com.swd.ttt.entity.heuristic.WinDiagonalHeuristic;
import com.swd.ttt.entity.heuristic.WinRowHeuristic;
import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

public class SinglePlayFutureWinEval implements Eval {

    private WinRowHeuristic winRowHeuristic = new WinRowHeuristic();
    private WinColumnHeuristic winColumnHeuristic = new WinColumnHeuristic();
    private WinDiagonalHeuristic winDiagonalHeuristic = new WinDiagonalHeuristic();

    public boolean evaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

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
