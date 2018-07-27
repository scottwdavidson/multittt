package com.swd.ttt.entity.strategy;

import com.swd.ttt.entity.MovePosition;
import com.swd.ttt.entity.Turn;

import java.util.ArrayList;
import java.util.List;

/**
 * Immutable representation of a node in a Min/Max tree used to determine the best next move.
 */
public class MinMaxNode {

    public static enum MinMax{
        ROOT, MIN, MAX
    };

    private final MinMaxNode parent;
    private final List<MinMaxNode> children = new ArrayList<MinMaxNode>();
    private final MinMax minMax;
    private final MovePosition movePosition;
    private final int boardEvaluation;

    // TODO Dylan implement factories methods (one for Root, one for "others" passing in the parent MinMaxNode)
    public static MinMaxNode newRootMinMaxNode(){
        return null;
    }

    public static MinMaxNode newMinMaxNode(MinMaxNode prototype // other args ?
    ){
        return null;
    }

    public MinMaxNode getParent() {
        return parent;
    }

    public List<MinMaxNode> getChildren() {
        return children;
    }

    public MinMax getMinMax() {
        return minMax;
    }

    public MovePosition getMovePosition() {
        return movePosition;
    }

    public int getBoardEvaluation() {
        return boardEvaluation;
    }

    // Private constructor to force usage of factory method
    private MinMaxNode(MinMaxNode parent, MinMax minMax, MovePosition movePosition, int boardEvaluation){
        this.parent = parent;
        this.minMax = minMax;
        this.movePosition = movePosition;
        this.boardEvaluation = boardEvaluation;
    }
}
