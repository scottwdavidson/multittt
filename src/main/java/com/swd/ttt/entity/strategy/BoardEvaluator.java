package com.swd.ttt.entity.strategy;

import com.swd.ttt.entity.Board;
import com.swd.ttt.entity.TicTacToeBoard;

/**
 * Provides full Board evaluation logic in support of the MinMax strategy, identifying both *definite* cases and
 * more relative cases, encapsulating all evaluation into a single place.
 * <p>
 * A MinMaxBoardEvaluator will also provide some performance efficiency by generating a relative evaluation of the 8 inactive
 * TTT boards upon initialization and persist that state to allow the evaluation of multiple active TTT boards.
 * </p>
 */

// TODO Scott update description to account for abastract ( and concrete class approach )
public abstract class BoardEvaluator {

    public static class Evaluation {
        private int wins = 0;
        private int losses = 0;
        private int draws = 0;
        private int relativeValues = 0;

        public Evaluation() {
        }

        public Evaluation combineEvalutions(Evaluation coreEvalution) {
            Evaluation combinedEvalution = new Evaluation();
            combinedEvalution.plus(this);
            combinedEvalution.plus(coreEvalution);
            return combinedEvalution;
        }

        public Evaluation plus(Evaluation evaluation){
            this.wins(this.wins).wins(evaluation.wins);
            this.losses(this.wins).losses(evaluation.wins);
            this.draws(this.wins).draws(evaluation.wins);
            this.relativeValues(this.wins).relativeValues(evaluation.wins);
            return this;
        }

        public int getWins() {
            return wins;
        }

        public Evaluation wins(int wins) {
            this.wins += wins;
            return this;
        }

        public int getLosses() {
            return losses;
        }

        public Evaluation losses(int losses) {
            this.losses += losses;
            return this;
        }

        public int getDraws() {
            return draws;
        }

        public Evaluation draws(int draws) {
            this.draws += draws;
            return this;
        }

        public int getRelativeValues() {
            return relativeValues;
        }

        public Evaluation relativeValues(int relativeValues) {
            this.relativeValues += relativeValues;
            return this;
        }

    }

    private Board coreBoard;
    private Evaluation coreEvaluation;

    public BoardEvaluator() {
        this.coreBoard = null;
    }

    public BoardEvaluator(Board board) {

    }

    public int evaluate(Board board) {

        // Assign ( and update if necessary ) the core board and its evaluation
        this.assignCoreBoard(board);

        // Evaluate the Active TTT Board and then combine it with the core evaluation
        Evaluation activeTttBoardEvaluation = evaluateTTTBoard(board.getTttBoards()[board.activeTttBoard()]);
        Evaluation overallBoardEvaluation = activeTttBoardEvaluation.combineEvalutions(this.coreEvaluation);

        // Determine win/loss/draw relative values
        int winRelativeValue = winValue(overallBoardEvaluation);
        int lossRelativeValue = lossValue(overallBoardEvaluation);
        int drawRelativeValue = drawValue(overallBoardEvaluation);

        // Calculate the overall evaluation - sum up wins versus losses + relative values
        int overallBoardEvaluationValue =
                (overallBoardEvaluation.getWins() * winRelativeValue) +
                        (overallBoardEvaluation.getLosses() * lossRelativeValue) +
                        (overallBoardEvaluation.getDraws() * drawRelativeValue) +
                        (overallBoardEvaluation.getRelativeValues());

        return overallBoardEvaluationValue;
    }

    protected void assignCoreBoard(Board coreBoard) {

        // If same core, nothing to do ...
        if (this.coreBoard == null || this.coreBoard.getId() != coreBoard.getId()) {
            this.coreBoard = coreBoard;
            this.coreEvaluation = evaluateCoreBoard(this.coreBoard);
        }
    }

    /**
     * Evaluate the core ( that is, the non active TTT boards which aren't changing ), storing the result in the
     * core Evaluation member variable. This is not an absolute value b/c an absolute value can't be computed until
     * the
     */
    protected Evaluation evaluateCoreBoard(Board board) {

        Evaluation evaluation = new Evaluation();
        for(TicTacToeBoard ticTacToeBoard : board.getTttBoards()){
            if ( !ticTacToeBoard.isActive() ) {
                evaluation = evaluation.plus(evaluateTTTBoard(ticTacToeBoard));
            }
        }
        return evaluation;
    }

    protected Evaluation evaluateTTTBoard(TicTacToeBoard tictactoeBoard) {
        
        return new Evaluation();
    }

    /**
     * Depending on the specific strategy, determine the value of a win.
     */
    protected abstract int winValue(Evaluation overallBoardEvaluation);

    /**
     * Depending on the specific strategy, determine the value of a loss.
     */
    protected abstract int lossValue(Evaluation overallBoardEvaluation);

    /**
     * Depending on the specific strategy, determine the value of a draw.
     */
    protected abstract int drawValue(Evaluation overallBoardEvaluation);

}
