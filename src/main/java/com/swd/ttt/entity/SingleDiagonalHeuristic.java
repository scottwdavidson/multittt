package com.swd.ttt.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleDiagonalHeuristic extends AbstractSingleHeuristic {

    private final static int RELATIVE_VALUE = 1;

    public static SingleDiagonalHeuristic newSingleDiagonalHeuristic(){
        return new SingleDiagonalHeuristic(RELATIVE_VALUE);
    }

    @Override
    public Set<Integer> moves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        Set<Integer> returnMoves = new HashSet<>();

        // Top Left / Bottom Right
        if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(), (short) 0b100010001, (short) 0b00000001) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(), (short) 0b100010000, (short) 0b00000000)) {

            returnMoves.add(4);
            returnMoves.add(8);
        }
        else if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(), (short) 0b100010001, (short) 0b00010000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(), (short) 0b100000001, (short) 0b00000000)) {

            returnMoves.add(0);
            returnMoves.add(8);
        }
        else if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(), (short) 0b100010001, (short) 0b100000000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(), (short) 0b000010001, (short) 0b00000000)) {

            returnMoves.add(0);
            returnMoves.add(4);
        }


        // Top Right / Bottom Left
        if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(), (short) 0b001010100, (short) 0b00000100) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(), (short) 0b001010000, (short) 0b00000000)) {

            returnMoves.add(4);
            returnMoves.add(6);
        }
        else if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(), (short) 0b001010100, (short) 0b00010000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(), (short) 0b001000100, (short) 0b00000000)) {

            returnMoves.add(2);
            returnMoves.add(6);
        }
        else if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(), (short) 0b001010100, (short) 0b001000000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(), (short) 0b000010100, (short) 0b00000000)) {

            returnMoves.add(2);
            returnMoves.add(4);
        }


        return returnMoves;
    }

    private SingleDiagonalHeuristic(int relativeValue) {
        super(relativeValue);

    }
}
