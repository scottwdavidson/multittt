package com.swd.ttt.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSingleHeuristic implements Heuristic {

    private final int relativeValue;

    @Override
    public int relativeValue() {
        return relativeValue;
    }

    protected boolean mask(short playerRepresentation, short mask, short exoectedMaskedPlayerRepresentation){
        int maskedPlayerRepresentation = playerRepresentation & mask;
        return (short) maskedPlayerRepresentation == exoectedMaskedPlayerRepresentation;
    }

    protected AbstractSingleHeuristic(int relativeValue){
        this.relativeValue = relativeValue;
    }
}
