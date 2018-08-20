package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

public interface Eval {

    boolean evaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent);
}
