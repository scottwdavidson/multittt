package com.swd.ttt.entity;

import java.util.List;

public interface Heuristic {

    /**
     * Provides the relative value of the local strategy ( > 0 ) so that strategies may be compared to each other.
     */
    int relativeValue();

    /**
     * Provides the list of legal moves on the provided tictactoe board based on this heuristic.
     */
    List<Integer> moves(TicTacToeBoard tictactoeBoard);
}
