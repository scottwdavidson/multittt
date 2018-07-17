package com.swd.ttt.entity;

import java.util.List;
import java.util.ArrayList;

/**
 * The aggregation of a set of like valued Heuristic objects.
 */
public class AggregatedHeuristic implements Heuristic {

    private List<Heuristic> heuristics = new ArrayList<Heuristic>();

    @Override
    public int relativeValue(){

        if (heuristics.isEmpty()){
            throw new IllegalArgumentException("There are no Heuristics added to this aggregation yet so relative value can't be determined.");
        }

        return heuristics.get(0).relativeValue();
    }

    @Override
    public List<Integer> moves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        List<Integer> moves = new ArrayList<Integer>();
        for(Heuristic heuristic: this.heuristics){
            moves.addAll(heuristic.moves(tictactoeBoard, activePlayer, opponent));
        }
        return moves;
    }

    public void addHeuristic(Heuristic heuristic){

        if (!heuristics.isEmpty() && heuristic.relativeValue() != this.relativeValue()){
            throw new IllegalArgumentException("The provided heuristic can not be added b/c it's a different relative value ( " +
            this.relativeValue() + " != " + heuristic.relativeValue());
        }

        heuristics.add(heuristic);
    }
}
