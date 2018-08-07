package com.swd.ttt.entity.strategy;

import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.TicTacToeBoard;
import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.eval.DrawEval;
import com.swd.ttt.entity.eval.WinEval;

/**
 * Provides a general Board evaluation algorithm in the context of the provided root player, leaving the specific
 * calculation of a win, loss, draw or other relative score to be determined by a concrete BoardEvaluator.
 */

// TODO Scott update description to account for abstract ( and concrete class approach )
public abstract class BoardEvaluator {

    public static class Evaluation {
        private int wins = 0;
        private int losses = 0;
        private int draws = 0;
        private int relativeValues = 0;

        public Evaluation() {
        }

        public Evaluation combineEvaluations(Evaluation coreEvalution) {
            Evaluation combinedEvalution = new Evaluation();
            combinedEvalution.plus(this);
            combinedEvalution.plus(coreEvalution);
            return combinedEvalution;
        }

        public Evaluation plus(Evaluation evaluation){
            this.plusWins(this.wins).plusWins(evaluation.wins);
            this.plusLosses(this.wins).plusLosses(evaluation.wins);
            this.plusDraws(this.wins).plusDraws(evaluation.wins);
            this.relativeValues(this.wins).relativeValues(evaluation.wins);
            return this;
        }

        public int getWins() {
            return wins;
        }

        public Evaluation plusWins(int wins) {
            this.wins += wins;
            return this;
        }

        public int getLosses() {
            return losses;
        }

        public Evaluation plusLosses(int losses) {
            this.losses += losses;
            return this;
        }

        public int getDraws() {
            return draws;
        }

        public Evaluation plusDraws(int draws) {
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

//    private Board coreBoard;
//    private Evaluation coreEvaluation;

    public BoardEvaluator() {
//        this.coreBoard = null;
    }

    public int evaluate(Player rootPlayer, Board board) {

        // Restart of this method w/out any optimizations ( which may be causing issues )
        //
        // Iterate through all of the boards, evaluate them and return a score
        Evaluation summaryEvaluation = new Evaluation();
        for(TicTacToeBoard ticTacToeBoard: board.getTttBoards()){
            Evaluation evaluation = evaluateTTTBoard(rootPlayer, ticTacToeBoard);
            summaryEvaluation = summaryEvaluation.combineEvaluations(evaluation);
        }

        // Determine win/loss/draw relative values
        int winRelativeValue = winValue(summaryEvaluation);
        int lossRelativeValue = lossValue(summaryEvaluation);
        int drawRelativeValue = drawValue(summaryEvaluation);

        // Calculate the overall evaluation - sum up plusWins versus plusLosses + relative values
        int summaryBoardEvaluationValue =
                (summaryEvaluation.getWins() * winRelativeValue) +
                        (summaryEvaluation.getLosses() * lossRelativeValue) +
                        (summaryEvaluation.getDraws() * drawRelativeValue) +
                        (summaryEvaluation.getRelativeValues());

        return summaryBoardEvaluationValue;

//        // Assign ( and update if necessary ) the core board and its evaluation
////        this.assignCoreBoard(rootPlayer, board);
//
//        // Evaluate the Active TTT Board and then combine it with the core evaluation
//        Evaluation activeTttBoardEvaluation = evaluateTTTBoard(rootPlayer, board.getTttBoards()[board.getActiveTicTacToeBoardIndex()]);
//        Evaluation overallBoardEvaluation = activeTttBoardEvaluation.combineEvalutions(this.coreEvaluation);
//
//        // Determine win/loss/draw relative values
//        int winRelativeValue = winValue(overallBoardEvaluation);
//        int lossRelativeValue = lossValue(overallBoardEvaluation);
//        int drawRelativeValue = drawValue(overallBoardEvaluation);
//
//        // Calculate the overall evaluation - sum up plusWins versus plusLosses + relative values
//        int overallBoardEvaluationValue =
//                (overallBoardEvaluation.getWins() * winRelativeValue) +
//                        (overallBoardEvaluation.getLosses() * lossRelativeValue) +
//                        (overallBoardEvaluation.getDraws() * drawRelativeValue) +
//                        (overallBoardEvaluation.getRelativeValues());
//
//        return overallBoardEvaluationValue;
    }

//    protected void assignCoreBoard(Player rootPlayer, Board coreBoard) {
//
//        // If same core, nothing to do ...
//        if (this.coreBoard != null && (this.coreBoard.getId() == coreBoard.getId() && this.coreBoard.getMoveNumber() == coreBoard.getMoveNumber())) {
//            ;
//        }
//        else {
//            this.coreBoard = coreBoard;
//            this.coreEvaluation = evaluateCoreBoard(rootPlayer, this.coreBoard);
//        }
//    }

    /**
     * Evaluate the core ( that is, the non active TTT boards which aren't changing ), storing the result in the
     * core Evaluation member variable. This is not an absolute value b/c an absolute value can't be computed until
     * the all boards (including the active board is evaluated).
     */
    protected Evaluation evaluateCoreBoard(Player rootPlayer, Board board) {

        Evaluation evaluation = new Evaluation();
        for(int index = 0; index < board.getTttBoards().length; index++){
            if ( board.getActiveTicTacToeBoardIndex() != index ) {
                evaluation = evaluation.plus(evaluateTTTBoard(rootPlayer, board.getTttBoards()[index]));
            }
            else {
                //TODO Evaluate the inactive TTT Boards
            }
        }
        return evaluation;
    }

    protected Evaluation evaluateTTTBoard(Player rootPlayer, TicTacToeBoard tictactoeBoard) {

        Evaluation evaluation = new Evaluation();

        // Check for win ( for either player )
        WinEval winEval = new WinEval();  // TODO should use IOC
        DrawEval drawEval = new DrawEval();
        if(winEval.evaluationMatches(tictactoeBoard, rootPlayer, rootPlayer.opponent())){
            evaluation.plusWins(1);
        }
        else if(winEval.evaluationMatches(tictactoeBoard, rootPlayer.opponent(), rootPlayer)){
            evaluation.plusLosses(1);
        }

        // Check for draw
        else if(drawEval.evaluationMatches(tictactoeBoard, rootPlayer, rootPlayer.opponent())){
            evaluation.plusDraws(1);
        }

        // Delegate to concrete Strategic Board Evaluator for relative values
        else {
            evaluation = evaluateTTTBoardRelativeValue(rootPlayer, tictactoeBoard);
        }

        return evaluation;
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

    /**
     * Depending on the specific strategy, evaluate the non Win / non Draw TTT board
     */
    protected abstract Evaluation evaluateTTTBoardRelativeValue(Player rootPlayer, TicTacToeBoard ticTacToeBoard);
}
