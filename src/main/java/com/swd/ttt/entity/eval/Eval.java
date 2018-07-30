package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;

public interface Eval {

    boolean evaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent);
}
