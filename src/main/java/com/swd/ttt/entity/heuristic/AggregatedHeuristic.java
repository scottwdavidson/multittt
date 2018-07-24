package com.swd.ttt.entity.heuristic;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import com.swd.ttt.entity.Heuristic;
import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;

/**
 * The aggregation of a set of like valued Heuristic objects.
 */
public class AggregatedHeuristic implements Heuristic {

    private Set<Heuristic> heuristics = new HashSet<>();

    @Override
    public int relativeValue(){

        if (heuristics.isEmpty()){
            throw new IllegalArgumentException("There are no Heuristics added to this aggregation yet so relative value can't be determined.");
        }

        return heuristics.iterator().next().relativeValue();
    }

    @Override
    public Set<Integer> moves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        Set<Integer> moves = new HashSet<>();
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
