package com.swd.ttt.entity.strategy.minmax;

import com.swd.ttt.entity.*;
import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.MovePosition;

import java.util.List;

public class MinMaxStrategy implements Strategy {

    private final Turn turn = new Turn();  // TODO Autowire Turn instance

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
        createNextLevelMinMaxNodes(rootMinMaxNode, board, 5);

        System.out.println("NODE TREE: \n" + rootTreeToString(rootMinMaxNode));

        // Evaluate the Tree ( resulting in the root node have an evaluation )
        evaluateTree(rootMinMaxNode);

        // Iterate the root's immediate children to find the highest value and get it's MovePosition
        MovePosition strategicMovePosition = rootMinMaxNode.getMovePosition();

        // Execute the move on the provided Board and return the updated Board
        return this.turn.executeTurn(board, strategicMovePosition);
    }

    private void createNextLevelMinMaxNodes(MinMaxNode parent, Board board, int levels) {

        if (levels == 0) {
            return;
        }

        // Get the set of all available MovePositions from the Board
        List<MovePosition> movePositions = board.activeTttBoardMovePositions();

        // For each MovePosition
        //  1. Execute a turn on the Board for each MovePosition
        //  2. Evaluate the Board for just a win at all levels (assign value if a win), otherwise only assign the
        //      the leaf node value
        //  3. Create a new MinMaxNode (w/ the parent, MovePosition, Evaluation and (flipped) MinMax) and add
        //      child to the parent
        //  4. Recursively create the next level ( make sure to decrement levels and flip MinMax )
        for (MovePosition movePosition : movePositions) {

            Board newBoard = this.turn.executeTurn(board, movePosition);

            //if there is a win or if level == 0: evaluate board

            MinMaxNode minMaxNodeChild = MinMaxNode.newMinMaxNode(parent, parent.getMinMax().next(), movePosition);

            createNextLevelMinMaxNodes(minMaxNodeChild, newBoard, levels - 1);


        }
    }

    private void evaluateTree(MinMaxNode parent) {

        // Recursively evaluate based on MinMax for the current level, updating the "local" nodes - depth first

        if (parent.getChildren() == null) {
            return;
        }

        int minMaxEvalValue = parent.getChildren().get(0).getBoardEvaluation();
        MovePosition minMaxMovePosition = parent.getChildren().get(0).getMovePosition();

        for (MinMaxNode childNode : parent.getChildren()) {
            evaluateTree(childNode);
            if ((childNode.getBoardEvaluation() > minMaxEvalValue && childNode.getMinMax() == MinMaxNode.MinMax.MAX) ||
                    (childNode.getBoardEvaluation() < minMaxEvalValue && childNode.getMinMax() == MinMaxNode.MinMax.MIN)) {
                minMaxEvalValue = childNode.getBoardEvaluation();
                minMaxMovePosition = childNode.getMovePosition();
            }
        }

        parent.setBoardEvaluation(minMaxEvalValue);
        parent.setMovePosition(minMaxMovePosition);

    }

    private MovePosition getHighestValueMovePosition(MinMaxNode root) {
        return null;
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

}
