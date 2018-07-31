package com.swd.ttt.entity.heuristic;

import java.util.HashSet;
import java.util.Set;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

public class SingleRowHeuristic extends AbstractSingleHeuristic {

    private final static int RELATIVE_VALUE = 1;

    public static SingleRowHeuristic newSingleRowHeuristic(){
        return new SingleRowHeuristic(RELATIVE_VALUE);
    }


    @Override
    public Set<Integer> moves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        Set<Integer> returnMoves = new HashSet<>();

        // Top Row
        if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer),(short) 0b000000111, (short) 0b00000001) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent),(short) 0b000000110, (short) 0b00000000)){

            returnMoves.add(2);
            returnMoves.add(1);
        }
        else if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b000000111, (short) 0b00000010) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b000000101, (short) 0b00000000)){

            returnMoves.add(2);
            returnMoves.add(0);
        }
        else if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b000000111, (short) 0b00000100) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b000000011, (short) 0b00000000)){

            returnMoves.add(1);
            returnMoves.add(0);
        }

        // Middle Row
        if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b000111000, (short) 0b00001000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b000110000, (short) 0b00000000)){

            returnMoves.add(5);
            returnMoves.add(4);
        }
        else if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b000111000, (short) 0b00010000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b000101000, (short) 0b00000000)){

            returnMoves.add(5);
            returnMoves.add(3);
        }
        else if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b000111000, (short) 0b00100000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b000011000, (short) 0b00000000)){

            returnMoves.add(4);
            returnMoves.add(3);
        }

        // Bottom Row
        if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b111000000, (short) 0b001000000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b110000000, (short) 0b00000000)){

            returnMoves.add(8);
            returnMoves.add(7);
        }
        else if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b111000000, (short) 0b010000000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b101000000, (short) 0b00000000)){

            returnMoves.add(8);
            returnMoves.add(6);
        }
        else if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b111000000, (short) 0b100000000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b011000000, (short) 0b00000000)){

            returnMoves.add(7);
            returnMoves.add(6);
        }

        return returnMoves;
    }

    private SingleRowHeuristic(int relativeValue) {
        super(relativeValue);

    }

}
