package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

public class EmptyEval implements Eval {

    @Override
    public boolean evaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        // Neither X or O plays
        if (MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b111111111, (short) 0b000000000) &&
                (MaskHelper.mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b111111111, (short) 0b000000000)))
        {
            return true;
        }

        return false;
    }


}
