package com.swd.ttt.entity;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

import java.util.Set;

public interface Heuristic {

    /**
     * Provides the relative value of the local strategy ( > 0 ) so that strategies may be compared to each other.
     */
    int relativeValue();

    /**
     * Provides the list of legal moves on the provided tictactoe board based on this heuristic.
     */
    Set<Integer> moves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent);
}
