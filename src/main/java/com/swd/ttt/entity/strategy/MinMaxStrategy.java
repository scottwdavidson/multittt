package com.swd.ttt.entity.strategy;

import com.swd.ttt.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MinMaxStrategy implements Strategy {

    @Override
    public List<Heuristic> prioritizedAutomatonHeuristics() {
        return null;
    }

    @Override
    public List<Heuristic> prioritizedOpponentHeuristics() {
        return null;
    }

    @Override
    public Board executeMove(Board board) {

        // Create the Root Node
        MinMaxNode rootMinMaxNode = MinMaxNode.newRootMinMaxNode();

        // Create the Tree
        createNextLevelMinMaxNodes(rootMinMaxNode,board,5, MinMaxNode.MinMax.ROOT);

        // Evaluate the Tree ( resulting in the root node have an evaluation )
        evaluateTree(rootMinMaxNode);

        // Iterate the root's immediate children to find the highest value and get it's MovePosition
        MovePosition strategicMovePosition = rootMinMaxNode.getMovePosition();

        // Execute the move on the provided Board and return the updated Board
        return Turn.executeTurn(strategicMovePosition,board);
    }

    private void createNextLevelMinMaxNodes(MinMaxNode parent, Board board, int levels, MinMaxNode.MinMax minMax){

        if (levels == 0 ){
            return;
        }

        // Get the set of all available MovePositions from the Board
        List<MovePosition> movePositions = board.activeTttBoardMovePositions();

        // For each MovePosition
        //  1. Execute a turn on the Board for each MovePosition (and store the list of new Boards)
        //  2. Evaluate the Board for just a win at all levels (assign value if a win), otherwise only assign the
        //      the leaf node value
        //  3. Create a new MinMaxNode (w/ the parent, MovePosition, Evaluation and (flipped) MinMax) and add
        //      child to the parent
        //  4. Recursively create the next level ( make sure to decrement levels and flip MinMax )
        for(MovePosition movePosition : movePositions){


        }
    }

    private void evaluateTree(MinMaxNode parent){

        // Recursively evaluate based on MinMax for the current level, updating the "local" nodes - depth first

    }

    private MovePosition getHighestValueMovePosition(MinMaxNode root){
        return null;
    }
}
