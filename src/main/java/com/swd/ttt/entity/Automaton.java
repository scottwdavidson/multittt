package com.swd.ttt.entity;

import java.util.List;

/**
 * Represents the "computer player" which applies the configured Strategies to make the optimal ( as optimal as the Strategy can guarantee ) move.
 */
public class Automaton {

    private Strategy strategy;

    public static Automaton newAutomaton(Strategy strategy){
        Automaton automaton = new Automaton();
        automaton.setStrategy(strategy);
        return automaton;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Performs a move on the active board by applying the configured strategy for the identified player.
     * @param board
     * @param activeTicTacToeBoard
     */
    public void move(Board board, int activeTicTacToeBoard, Player activePlayer, Player opponent){

        // Iterate through the prioritized list of Automaton Strategy objects
        for ( Heuristic automatonHeuristic : this.strategy.prioritizedAutomatonHeuristics()){

            List<Integer> moves = automatonHeuristic.moves(board.getTttBoards()[activeTicTacToeBoard], activePlayer, opponent);

            if ( null != moves && !moves.isEmpty() ){

                if (1 == moves.size()) {

                    // A single move - got to go w/ it
                    move(board, activeTicTacToeBoard, activePlayer, moves.get(0));  
                }
            }
        }
    }

    private void move(Board board, int activeTicTacToeBoard, Player player, int position){
        board.getTttBoards()[activeTicTacToeBoard].addMove(player,position);
    }
}
