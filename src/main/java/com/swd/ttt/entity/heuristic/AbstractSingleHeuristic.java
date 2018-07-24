package com.swd.ttt.entity.heuristic;

import com.swd.ttt.entity.Heuristic;


public abstract class AbstractSingleHeuristic implements Heuristic {

    private final int relativeValue;

    @Override
    public int relativeValue() {
        return relativeValue;
    }

    protected boolean mask(short playerRepresentation, short mask, short expectedMaskedPlayerRepresentation){
        int maskedPlayerRepresentation = playerRepresentation & mask;
        return (short) maskedPlayerRepresentation == expectedMaskedPlayerRepresentation;
    }

    protected AbstractSingleHeuristic(int relativeValue){
        this.relativeValue = relativeValue;
    }
}
