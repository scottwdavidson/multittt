package com.swd.ttt.entity.strategy.minmax;

import com.swd.ttt.entity.*;
import com.swd.ttt.entity.eval.DrawEval;
import com.swd.ttt.entity.eval.WinEval;
import com.swd.ttt.entity.heuristic.MinimizeInitialMovesHeuristic;
import com.swd.ttt.entity.heuristic.SingleDiagonalHeuristic;
import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.GameState;
import com.swd.ttt.entity.play.MovePosition;
import com.swd.ttt.entity.play.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MinMaxStrategy implements Strategy {

    private final Turn turn = new Turn(); // TODO Autowire Turn instance
    private final MinMaxBoardEvaluator minMaxBoardEvaluator = new MinMaxBoardEvaluator(); // TODO
    // Autowire
    private final WinEval winEval = new WinEval(); // TODO Autowire
    private final DrawEval drawEval = new DrawEval();
    private final MinMaxNodeEvaluator minMaxNodeEvaluator = new MinMaxNodeEvaluator();
    private MinimizeInitialMovesHeuristic minimizeInitialMovesHeuristic = new MinimizeInitialMovesHeuristic(); // TODO
    // Autowire

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
        createNextLevelMinMaxNodes(board.getActivePlayer(), rootMinMaxNode,
                board, 3);

        // Evaluate the Tree ( resulting in the root node have an evaluation )
        evaluateTree(board.getActivePlayer(), rootMinMaxNode);

        // Iterate the root's immediate children to find the highest value and
        // get it's MovePosition
        MovePosition strategicMovePosition = rootMinMaxNode.getMovePosition();

        // Execute the move on the provided Board and return the updated Board
        return this.turn.executeTurn(board, strategicMovePosition);
    }

    private void createNextLevelMinMaxNodes(Player rootPlayer,
                                            MinMaxNode parent, Board board, int levels) {

        if (levels == 0) {
            return;
        }

        // Get the set of all available MovePositions from the Board
        List<MovePosition> movePositions = board.activeTttBoardMovePositions();

        // If there are > 6 moves, delete extras
        movePositions = adjustMovePositions(movePositions, rootPlayer, board);

        // For each MovePosition
        // 1. Execute a turn on the Board for each MovePosition
        // 2. Evaluate the Board for just a win at all levels (assign value if a
        // win), otherwise only assign the
        // the leaf node value
        // 3. Create a new MinMaxNode (w/ the parent, MovePosition, Evaluation
        // and (flipped) MinMax) and add
        // child to the parent
        // 4. Recursively create the next level ( make sure to decrement levels
        // and flip MinMax )
        for (MovePosition movePosition : movePositions) {

            // Create new board by applying move
            Board newBoard = this.turn.executeTurn(board, movePosition);

            // If a leaf *or* an overall win *or* an overall draw, evaluate the
            // board and break recursive loop
            int boardEvaluation = 0;
            boolean done = false;
            if ((levels == 1) || (newBoard.getGameState() == GameState.Closed)) {
                boardEvaluation = this.minMaxBoardEvaluator.evaluate(
                        rootPlayer, newBoard);
                done = true;
            }

            MinMaxNode minMaxNodeChild = MinMaxNode.newMinMaxNode(parent,
                    parent.getMinMax().next(), movePosition, boardEvaluation);

            // Recursively create the next level node for this child ( if not
            // done )
            if (!done) {
                createNextLevelMinMaxNodes(rootPlayer, minMaxNodeChild,
                        newBoard, levels - 1);
            }
        }
    }

    private void evaluateTree(Player rootPlayer, MinMaxNode minMaxNode) {

        // If Leaf node - just return so actual min/max evaluation can start
        if (!minMaxNode.getChildren().isEmpty()) {

            // Recursively iterate through all of the children of the current
            // node to get them evaluated
            for (MinMaxNode child : minMaxNode.getChildren()) {
                evaluateTree(rootPlayer, child);
            }

            // Assign the evaluation value of the children to this node
            MinMaxNode minMaxEvalValue = this.minMaxNodeEvaluator.childrenEvaluation(minMaxNode,
                    minMaxNode.getChildren().get(0).getMinMax());
            minMaxNode.setBoardEvaluation(minMaxEvalValue.getBoardEvaluation());

            // If root node, also add the MovePosition
            if (minMaxNode.getMinMax() == MinMaxNode.MinMax.ROOT) {
                minMaxNode.setMovePosition(minMaxEvalValue.getMovePosition());
            }
        }
    }

    /**
     * Breadth first String representation of the Node Tree
     */
    private String rootTreeToString(MinMaxNode root) {

        return "[" + root.toString() + "] \n" + nodeTreeToString(root, true);
    }

    /**
     * Breadth first recursive method to create a String representation of the
     * Node Tree
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
            builder.append(nodeTreeToString(node.getChildren().get(index),
                    index == node.getChildren().size() - 1));
        }

        return builder.toString();
    }

    private List<MovePosition> adjustMovePositions(
            List<MovePosition> movePositions, Player rootPlayer, Board board) {
        Set<Integer> minimizationHeuristicMoves = minimizeInitialMovesHeuristic
                .moves(board.getTttBoards()[board
                                .getActiveTicTacToeBoardIndex()], rootPlayer,
                        rootPlayer.opponent());
        if (minimizationHeuristicMoves.isEmpty()) {
            return movePositions;
        }
        List<Integer> minimizationHeuristicMovesList = new ArrayList<>(minimizationHeuristicMoves);
        return MovePosition.newMovePositionList(board.getActiveTicTacToeBoardIndex(), minimizationHeuristicMovesList);
    }

}
