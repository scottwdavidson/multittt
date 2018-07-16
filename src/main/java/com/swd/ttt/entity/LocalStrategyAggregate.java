package com.swd.ttt.entity;

import java.util.List;
import java.util.ArrayList;

public class LocalStrategyAggregate implements LocalStrategy {

    private List<LocalStrategy> strategies = new ArrayList<LocalStrategy>();

    public List<LocalStrategy> getStrategies() {
        return strategies;
    }

    @Override
    public List<Integer> movesMeetingStrategy(TicTacToeBoard tictactoeBoard) {

        List<Integer> moves = new ArrayList<Integer>();
        for(LocalStrategy localStrategy: this.strategies){
            moves.addAll(localStrategy.movesMeetingStrategy(tictactoeBoard));
        }
        return moves;
    }

}
