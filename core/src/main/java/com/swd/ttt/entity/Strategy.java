package com.swd.ttt.entity;

import com.swd.ttt.entity.play.Board;

import java.util.List;

/**
 * Defines a particular strategy for an automaton player, providing a prioritized list of heuristics to be applied to the
 * current tictactoe board as well as a prioritized list of opponent heuristics to be used in for tie breaking (i.e., the
 * case where there are multiple moves provided by the automaton heuristic).
 */
public interface Strategy {

    /**
     * Returns a prioritized list of Heuristics to be applied in order until one yields a valid move for the automaton.
     */
    @Deprecated List<Heuristic> prioritizedAutomatonHeuristics();

    /**
     * Returns a prioritized list of Heuristics to be applied when tie breaking is required to choose the best
     * valid move for the automaton.
     */
    @Deprecated List<Heuristic> prioritizedOpponentHeuristics();

    /**
     * Execute a move on the provided Board ( and return the updated Board )
     */
    Board executeMove(Board board);

}
