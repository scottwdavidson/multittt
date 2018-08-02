package com.swd.ttt.entity.strategy.minmax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.swd.ttt.entity.eval.EmptyEval;
import com.swd.ttt.entity.eval.Eval;
import com.swd.ttt.entity.eval.MultiPlayFutureWinEval;
import com.swd.ttt.entity.eval.MultiSingleRowColumnDiagonalEval;
import com.swd.ttt.entity.eval.PreMultiPlayFutureWinEval;
import com.swd.ttt.entity.eval.SinglePlayFutureWinEval;
import com.swd.ttt.entity.eval.SingleRowColumnDiagonalEval;
import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;
import com.swd.ttt.entity.strategy.BoardEvaluator;

/**
 * Provides full Board evaluation logic in support of the MinMax strategy, identifying both *definite* cases and
 * more relative cases, encapsulating all evaluation into a single place.
 * <p>
 * A MinMaxBoardEvaluator will also provide some performance efficiency by generating a relative evaluation of the 8 inactive
 * TTT boards upon initialization and persist that state to allow the evaluation of multiple active TTT boards.
 * </p>
 */
// TODO Scott update description to account for abastract ( and concrete class approach )

public class MinMaxBoardEvaluator extends BoardEvaluator {
	
	public static class RelativeEval implements Comparable<RelativeEval>{
		
		private final Eval eval;
		private final int value;
		
		public static RelativeEval newRelativeEval(Eval eval, int value){
			return new RelativeEval(eval, value);
		}
		
		private RelativeEval(Eval eval, int value){
			this.eval = eval;
			this.value = value;
		}

		@Override
		public int compareTo(RelativeEval o) {
			// TODO Auto-generated method stub
			return Integer.valueOf(o.value).compareTo(this.value);
		}
		
		public Eval getEval() {
			return eval;
		}

		public int getValue() {
			return value;
		}
	}

    private final static int OVERALL_TTT_BOARD_VALUATION = 99;
    
    private final static List<RelativeEval> RELATIVE_EVALS = new ArrayList<>();
    
    static {
    	RELATIVE_EVALS.add(RelativeEval.newRelativeEval(new MultiPlayFutureWinEval(), 6));
    	RELATIVE_EVALS.add(RelativeEval.newRelativeEval(new SinglePlayFutureWinEval(), 5));
    	RELATIVE_EVALS.add(RelativeEval.newRelativeEval(new PreMultiPlayFutureWinEval(), 4));
    	RELATIVE_EVALS.add(RelativeEval.newRelativeEval(new MultiSingleRowColumnDiagonalEval(), 2));
    	RELATIVE_EVALS.add(RelativeEval.newRelativeEval(new SingleRowColumnDiagonalEval(), 1));
    	RELATIVE_EVALS.add(RelativeEval.newRelativeEval(new EmptyEval(), 0));
    	Collections.sort(RELATIVE_EVALS);
    }

    /**
     * The whole TTT board is worth 99 points ( e.g., 9 plusWins ). As plusDraws are introduced, plusWins (and conversely plusLosses)
     * become more valuable ( more negative valued ) as we keep the overall board value at 99.
     * <p>
     * For example:
     * 0 plusDraws : a win is worth 10 points ( a loss is -10 points )
     * 2 plusDraws : a win is worth 99/7 points (~14 points) ( a loss is ~-14 points )
     * 5 plusDraws : a win is worth 99/4 points (~24 points)
     * </p>
     * <p>
     * The logic rounds up the quotient of totals points / remain TTT boards in play
     * </p>
     */
    protected int winValue(Evaluation overallBoardEvaluation) {

        int remainingTttBoards = 9 - overallBoardEvaluation.getDraws();

        if (remainingTttBoards == 9) {
            return OVERALL_TTT_BOARD_VALUATION / 9;
        } else {
            int value = OVERALL_TTT_BOARD_VALUATION / remainingTttBoards + ((OVERALL_TTT_BOARD_VALUATION % remainingTttBoards == 0) ? 0 : 1);
            return value;
        }
    }

    /**
     * A loss is just the opposite of a win in value for this MinMax strategy.
     */
    protected int lossValue(Evaluation overallBoardEvaluation){
        return -1 * winValue(overallBoardEvaluation);
    }

    /**
     * A draw has no value for this MinMax strategy.
     */
    protected int drawValue(Evaluation overallBoardEvaluation){
        return 0;
    }

    @Override
    protected Evaluation evaluateTTTBoardRelativeValue(Player rootPlayer, TicTacToeBoard ticTacToeBoard) {
    	Evaluation evaluation = new Evaluation();
    	
    	for(RelativeEval relativeEval : RELATIVE_EVALS){
    		if(relativeEval.getEval().evaluationMatches(ticTacToeBoard, rootPlayer, rootPlayer.opponent())){
    			return evaluation.relativeValues(relativeEval.getValue());
    		}
    		if(relativeEval.getEval().evaluationMatches(ticTacToeBoard, rootPlayer.opponent(), rootPlayer)){
    			return evaluation.relativeValues(-1 * relativeEval.getValue());
    		}
    	}
    	
    	return evaluation.relativeValues(0);
    }

}
