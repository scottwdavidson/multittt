package com.swd.ttt.entity;

import java.util.*;

/**
 * Represents the "computer player" which applies the configured Strategies to make the optimal ( as optimal as the Strategy can guarantee ) move.
 */
public class Automaton {

    public static class EvaluatedMove implements Comparable<EvaluatedMove> {

        private int move;
        private int relativeValue;

        public static EvaluatedMove newEvaluatedMove(int move, int relativeValue) {
            EvaluatedMove returnEvaluatedMove = new EvaluatedMove();
            returnEvaluatedMove.setMove(move);
            returnEvaluatedMove.setRelativeValue(relativeValue);
            return returnEvaluatedMove;
        }

        public int getMove() {
            return move;
        }

        public void setMove(int move) {
            this.move = move;
        }

        public int getRelativeValue() {
            return relativeValue;
        }

        public void setRelativeValue(int relativeValue) {
            this.relativeValue = relativeValue;
        }

        @Override
        public int compareTo(EvaluatedMove comparison) {
            return Integer.valueOf(this.relativeValue).compareTo(Integer.valueOf(comparison.relativeValue));
        }
    }

    private Strategy strategy;

    public static Automaton newAutomaton(Strategy strategy) {
        Automaton automaton = new Automaton();
        automaton.setStrategy(strategy);
        return automaton;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Performs a move on the active board by applying the configured strategy for the identified player.<br>
     * The priotized heuristic for both the active player and opponent should give the *best* play for that player
     * ahead of lower values. This is critical so that high value for the opponent is identifie
     */
    public void move(Board board, int activeTicTacToeBoard, Player activePlayer, Player opponent) {

        // Iterate through the prioritized list of Automaton Strategy objects
        for (Heuristic automatonHeuristic : this.strategy.prioritizedAutomatonHeuristics()) {

            // Get the possible moves for the next highest priority Heuristic
            Set<Integer> moves = automatonHeuristic.moves(board.getTttBoards()[activeTicTacToeBoard], activePlayer, opponent);

            if (null != moves && !moves.isEmpty()) {

                // Only a single move - got to go w/ it
                if (1 == moves.size()) {

                    move(board, activeTicTacToeBoard, activePlayer, moves.iterator().next(),10); // TODO hard coded move number
                    break;
                }

                // Iterate through the TicTacToeBoards based on the move positions (from an opponent perspective) and
                // assign an opponent value to each board; choose the move which results in the lowest value for the opponent
                // board.
                else {
                    SortedMap<Integer, EvaluatedMove> evaluatedMoves = new TreeMap<>();

                    for (Integer move : moves) {

                        int tictactoeBoardIndex = move; // clarifies name for part of the algorithm

                        // If the move places the opponent on the same board (the active board), create a temporary board
                        // and add the move (so the evaluation will considered the proposed update)
                        TicTacToeBoard ticTacToeBoard = board.getTttBoards()[tictactoeBoardIndex];
                        if (tictactoeBoardIndex == activeTicTacToeBoard) {
                            ticTacToeBoard = TicTacToeBoard.prototypeTicTacToeBoard(board.getTttBoards()[activeTicTacToeBoard]);
                        }

                        for (Heuristic opponentHeuristic : this.strategy.prioritizedOpponentHeuristics()) {

                            Set<Integer> opponentMoves = opponentHeuristic.moves(ticTacToeBoard, opponent, activePlayer);

                            if (null != opponentMoves && !opponentMoves.isEmpty()) {
                                evaluatedMoves.put(opponentHeuristic.relativeValue(), EvaluatedMove.newEvaluatedMove(move, opponentHeuristic.relativeValue()));
                            }
                        }
                    }

                    move(board, activeTicTacToeBoard, activePlayer, evaluatedMoves.get(0).getMove(), 20); // TODO hard coded move number
                    break;
                }

            }
        }
    }

    protected SortedMap<Integer, EvaluatedMove> evaluateSecondaryOpponentMoves(Board board, int activeTicTacToeBoard,
                                                                               Player activePlayer, Player opponent,
                                                                               List<Integer> moves) {
        SortedMap<Integer, EvaluatedMove> evaluatedMoves = new TreeMap<>();

        for (Integer move : moves) {

            int tictactoeBoardIndex = move; // clarifies name for part of the algorithm

            // If the move places the opponent on the same board (the active board), create a temporary board
            // and add the move (so the evaluation will considered the proposed update)
            TicTacToeBoard ticTacToeBoard = board.getTttBoards()[tictactoeBoardIndex];
            if (tictactoeBoardIndex == activeTicTacToeBoard) {
                ticTacToeBoard = TicTacToeBoard.prototypeTicTacToeBoard(board.getTttBoards()[activeTicTacToeBoard]);
                // apply the move ...
            }

            for (Heuristic opponentHeuristic : this.strategy.prioritizedOpponentHeuristics()) {

                Set<Integer> opponentMoves = opponentHeuristic.moves(ticTacToeBoard, opponent, activePlayer);

                if (null != opponentMoves && !opponentMoves.isEmpty()) {
                    evaluatedMoves.put(opponentHeuristic.relativeValue(), EvaluatedMove.newEvaluatedMove(move, opponentHeuristic.relativeValue()));
                }
            }
        }


        return evaluatedMoves;
    }

    private void move(Board board, int activeTicTacToeBoard, Player player, int position, int moveNumber) {
        board.getTttBoards()[activeTicTacToeBoard].addMove(player, position, moveNumber);
    }
}
