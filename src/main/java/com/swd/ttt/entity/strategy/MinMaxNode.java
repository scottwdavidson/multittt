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
        ROOT, MIN, MAX;
        
        public MinMax next(){
        	if(this == MinMax.MIN || this == MinMax.ROOT){
        		return MinMax.MAX;
        	}else{
        		return MinMax.MIN;
        	}
        }
    };

    private final MinMaxNode parent;
    private final List<MinMaxNode> children = new ArrayList<MinMaxNode>();
    private final MinMax minMax;
    private MovePosition movePosition;
    private int boardEvaluation = Integer.MIN_VALUE;

    // TODO Dylan implement factories methods (one for Root, one for "others" passing in the parent MinMaxNode)
    
    //Unsure what board eval should be for root, null not allowed
    public static MinMaxNode newRootMinMaxNode(){
        return new MinMaxNode(null, MinMax.ROOT, null, 0);
    }

    //factory method for new MinMaxNode without a board value
    public static MinMaxNode newMinMaxNode(MinMaxNode parent, MinMax minMax, MovePosition movePosition){
        return new MinMaxNode(parent, minMax, movePosition, Integer.MIN_VALUE);
    }
    
    //factory method for new MinMaxNode without a board value
    public static MinMaxNode newMinMaxNode(MinMaxNode parent, MinMax minMax, MovePosition movePosition, int boardEvaluation){
        return new MinMaxNode(parent, minMax, movePosition, boardEvaluation);
    }

    public MinMaxNode getParent() {
        return parent;
    }

    public List<MinMaxNode> getChildren() {
        return children;
    }
    
    public void addChild(MinMaxNode child){
    	this.children.add(child);
    }

    public MinMax getMinMax() {
        return minMax;
    }

    public MovePosition getMovePosition() {
        return movePosition;
    }
    
    public void setMovePosition(MovePosition movePosition){
    	this.movePosition = movePosition;
    }

    public int getBoardEvaluation() {
        return boardEvaluation;
    }
    
    public void setBoardEvaluation(int boardEvaluation){
    	this.boardEvaluation = boardEvaluation;
    }

    // Private constructor to force usage of factory method
    private MinMaxNode(MinMaxNode parent, MinMax minMax, MovePosition movePosition, int boardEvaluation){
        this.parent = parent;
        this.minMax = minMax;
        this.movePosition = movePosition;
        this.boardEvaluation = boardEvaluation;
        
        parent.getChildren().add(this);
    }
}
