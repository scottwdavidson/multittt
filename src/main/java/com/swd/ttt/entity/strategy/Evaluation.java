package com.swd.ttt.entity.strategy;

/**
 * Builder-like class that manages the evaluation of a Board in terms of wins, losses, draws and then a
 * relative value obtained by combining relative values from multiple, individual Tic Tac Toe Boards.
 */
public class Evaluation implements Comparable<Evaluation> {

    private int wins = 0;
    private int losses = 0;
    private int draws = 0;
    private int relativeValues = 0;

    public Evaluation() {
    }

    public Evaluation combineEvaluations(Evaluation coreEvaluation) {
        Evaluation combinedEvaluation = new Evaluation();
        combinedEvaluation.plus(this);
        combinedEvaluation.plus(coreEvaluation);
        return combinedEvaluation;
    }

    public Evaluation plus(Evaluation evaluation) {
        Evaluation plusEvaluation = new Evaluation();
        plusEvaluation.plusWins(this.wins).plusWins(evaluation.wins);
        plusEvaluation.plusLosses(this.losses).plusLosses(evaluation.losses);
        plusEvaluation.plusDraws(this.draws).plusDraws(evaluation.draws);
        plusEvaluation.plusRelativeValues(this.relativeValues).plusRelativeValues(evaluation.relativeValues);
        return plusEvaluation;
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

    public Evaluation plusRelativeValues(int relativeValues) {
        this.relativeValues += relativeValues;
        return this;
    }

    @Override
    public int compareTo(Evaluation comparisonEvaluation) {

        // If *all* aspects are equals, return 0
        if ((this.wins == comparisonEvaluation.wins) && (this.losses == comparisonEvaluation.losses) &&
                (this.draws == comparisonEvaluation.draws) && (this.relativeValues == comparisonEvaluation.relativeValues)){
            return 0;
        }

        // Otherwise, return in terms of wins ( +1 ), losses (-1), draws (+1) and then true comparison of relative value
        if (this.wins > comparisonEvaluation.wins ){
            return +1;
        }
        else if ( this.losses > comparisonEvaluation.losses ){
            return -1;
        }
        else if ( this.draws > comparisonEvaluation.draws ){
            return +1;
        }
        else {
            return Integer.valueOf(this.relativeValues).compareTo(comparisonEvaluation.relativeValues);
        }
    }
}
