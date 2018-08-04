package com.swd.ttt.entity.strategy.minmax;

import com.swd.ttt.entity.*;
import com.swd.ttt.entity.eval.DrawEval;
import com.swd.ttt.entity.eval.WinEval;
import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.GameState;
import com.swd.ttt.entity.play.MovePosition;
import com.swd.ttt.entity.play.Player;

import java.util.List;
import java.util.Random;

public class MinMaxStrategy implements Strategy {

    private final Turn turn = new Turn();  // TODO Autowire Turn instance
    private final MinMaxBoardEvaluator minMaxBoardEvaluator = new MinMaxBoardEvaluator();  // TODO Autowire
    private final WinEval winEval = new WinEval();  // TODO Autowire
    private final DrawEval drawEval = new DrawEval();
    private final Random RANDOM = new Random( 99991);

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
        createNextLevelMinMaxNodes(board.getActivePlayer(), rootMinMaxNode, board, 7);

        // Evaluate the Tree ( resulting in the root node have an evaluation )
        evaluateTree(board.getActivePlayer(), rootMinMaxNode);

        // Iterate the root's immediate children to find the highest value and get it's MovePosition
        MovePosition strategicMovePosition = rootMinMaxNode.getMovePosition();

        // Execute the move on the provided Board and return the updated Board
        return this.turn.executeTurn(board, strategicMovePosition);
    }

    private void createNextLevelMinMaxNodes(Player rootPlayer, MinMaxNode parent, Board board, int levels) {

        if (levels == 0) {
            return;
        }

        // Get the set of all available MovePositions from the Board
        List<MovePosition> movePositions = board.activeTttBoardMovePositions();
        
        //If there are > 6 moves, delete extras
        movePositions = adjustMovePositions(movePositions);

        // For each MovePosition
        //  1. Execute a turn on the Board for each MovePosition
        //  2. Evaluate the Board for just a win at all levels (assign value if a win), otherwise only assign the
        //      the leaf node value
        //  3. Create a new MinMaxNode (w/ the parent, MovePosition, Evaluation and (flipped) MinMax) and add
        //      child to the parent
        //  4. Recursively create the next level ( make sure to decrement levels and flip MinMax )
        for (MovePosition movePosition : movePositions) {

            // Create new board by applying move
            Board newBoard = this.turn.executeTurn(board, movePosition);

            // If a leaf *or* an overall win *or* an overall draw, evaluate the board and break recursive loop
            int boardEvaluation = 0;
            boolean done = false;
            if ((levels == 1) || (newBoard.getGameState() == GameState.Closed)) {
                boardEvaluation = this.minMaxBoardEvaluator.evaluate(rootPlayer, newBoard);
                done = true;
            }

            MinMaxNode minMaxNodeChild = MinMaxNode.newMinMaxNode(parent,
                    parent.getMinMax().next(), movePosition, boardEvaluation);

            // Recursively create the next level node for this child ( if not done )
            if (!done) {
                createNextLevelMinMaxNodes(rootPlayer, minMaxNodeChild, newBoard, levels - 1);
            }
        }
    }

    private void evaluateTree(Player rootPlayer, MinMaxNode minMaxNode) {

        // If Leaf node - just return so actual min/max evaluation can start
        if (!minMaxNode.getChildren().isEmpty()) {

            // Recursively iterate through all of the children of the current node to get them evaluated
            for (MinMaxNode child : minMaxNode.getChildren()) {
                evaluateTree(rootPlayer, child);
            }

            // Assign the evaluation value of the children to this node
            MinMaxNode minMaxEvalValue = childrenEvaluation(minMaxNode, minMaxNode.getChildren().get(0).getMinMax());
            minMaxNode.setBoardEvaluation(minMaxEvalValue.getBoardEvaluation());

            // If root node, also add the MovePosition
            if (minMaxNode.getMinMax() == MinMaxNode.MinMax.ROOT) {
                minMaxNode.setMovePosition(minMaxEvalValue.getMovePosition());
            }
        }
    }

    private MinMaxNode childrenEvaluation(MinMaxNode parent, MinMaxNode.MinMax minMax) {

        // Determine whether to get MAX or MIN
        if (minMax == MinMaxNode.MinMax.MAX) {
            return maxEvaluation(parent);
        } else {
            return minEvaluation(parent);
        }
    }

    /**
     * Find and return the maximum value of the children nodes
     */
    private MinMaxNode maxEvaluation(MinMaxNode parent) {
        int randomStartIndex = RANDOM.nextInt(parent.getChildren().size());
        MinMaxNode maxValue = parent.getChildren().get(randomStartIndex);
        for (MinMaxNode child : parent.getChildren()) {
            if (child.getBoardEvaluation() > maxValue.getBoardEvaluation()) {
                maxValue = child;
            }
        }
        return maxValue;
    }

    /**
     * Find and return the minimum value of the children nodes
     */
    private MinMaxNode minEvaluation(MinMaxNode parent) {
        int randomStartIndex = RANDOM.nextInt(parent.getChildren().size());
        MinMaxNode minValue = parent.getChildren().get(randomStartIndex);
        for (MinMaxNode child : parent.getChildren()) {
            if (child.getBoardEvaluation() < minValue.getBoardEvaluation()) {
                minValue = child;
            }
        }

        return minValue;
    }


    /**
     * Breadth first String representation of the Node Tree
     */
    private String rootTreeToString(MinMaxNode root) {

        return "[" + root.toString() + "] \n" + nodeTreeToString(root, true);
    }

    /**
     * Breadth first recursive method to create a String representation of the Node Tree
     */
    private String nodeTreeToString(MinMaxNode node, boolean isLast) {

        StringBuilder builder = new StringBuilder();
        boolean firstTime = true;
        for (MinMaxNode child : node.getChildren()) {
            if (firstTime) {
                firstTime = false;
            } else {
                builder.append(" -- ");
            }
            builder.append("[").append(child.toString()).append("]");
        }
        if (isLast) {
            builder.append("\n\n");
        }
        for (int index = 0; index < node.getChildren().size(); index++) {
            builder.append(nodeTreeToString(node.getChildren().get(index), index == node.getChildren().size() - 1));
        }

        return builder.toString();
    }
    
    private List<MovePosition> adjustMovePositions(List<MovePosition> movePositions){
    	if(movePositions.size() > 6){
    		int numberMovesToDrop = movePositions.size() - 7;
    		for(int i=0; i<numberMovesToDrop; i++){
    			int nextRandomIndex = RANDOM.nextInt(movePositions.size());
    			movePositions.remove(nextRandomIndex);
    		}
    	}
    	return movePositions;
    }

}
