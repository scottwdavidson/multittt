package com.swd.ttt.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleRowHeuristic extends AbstractSingleHeuristic {

    private final static int RELATIVE_VALUE = 1;

    public static SingleRowHeuristic newSingleRowHeuristic(){
        return new SingleRowHeuristic(RELATIVE_VALUE);
    }


    @Override
    public Set<Integer> moves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        Set<Integer> returnMoves = new HashSet<>();

        // Top Row
        if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b000000111, (short) 0b00000001) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b000000110, (short) 0b00000000)){

            returnMoves.add(0b000000100);
            returnMoves.add(0b000000010);
        }
        else if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b000000111, (short) 0b00000010) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b000000101, (short) 0b00000000)){

            returnMoves.add(0b000000100);
            returnMoves.add(0b000000001);
        }
        else if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b000000111, (short) 0b00000100) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b000000011, (short) 0b00000000)){

            returnMoves.add(0b000000010);
            returnMoves.add(0b000000001);
        }

        // Middle Row
        if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b000111000, (short) 0b00001000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b000110000, (short) 0b00000000)){

            returnMoves.add(0b000100000);
            returnMoves.add(0b000010000);
        }
        else if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b000111000, (short) 0b00010000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b000101000, (short) 0b00000000)){

            returnMoves.add(0b000100000);
            returnMoves.add(0b000001000);
        }
        else if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b000111000, (short) 0b00100000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b000011000, (short) 0b00000000)){

            returnMoves.add(0b000010000);
            returnMoves.add(0b000001000);
        }

        // Bottom Row
        if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b111000000, (short) 0b001000000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b110000000, (short) 0b00000000)){

            returnMoves.add(0b100000000);
            returnMoves.add(0b010000000);
        }
        else if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b111000000, (short) 0b010000000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b101000000, (short) 0b00000000)){

            returnMoves.add(0b100000000);
            returnMoves.add(0b001000000);
        }
        else if( mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(),(short) 0b111000000, (short) 0b100000000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(),(short) 0b011000000, (short) 0b00000000)){

            returnMoves.add(0b010000000);
            returnMoves.add(0b001000000);
        }

        return returnMoves;
    }

    protected boolean mask(short playerRepresentation, short mask, short exoectedMaskedPlayerRepresentation){
        int maskedPlayerRepresentation = playerRepresentation & mask;
        return (short) maskedPlayerRepresentation == exoectedMaskedPlayerRepresentation;
    }

    private SingleRowHeuristic(int relativeValue) {
        super(relativeValue);

    }

}
