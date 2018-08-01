package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.heuristic.FutureWinHeuristic;
import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

public class PreMultiPlayFutureWinEval implements Eval {

    private FutureWinHeuristic futureWinHeuristic = new FutureWinHeuristic();

    public boolean evaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        return !futureWinHeuristic.moves(tictactoeBoard, activePlayer,opponent).isEmpty();
    }
}
