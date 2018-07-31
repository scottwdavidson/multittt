package com.swd.ttt.entity.heuristic;

import java.util.HashSet;
import java.util.Set;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

public class SingleColumnHeuristic extends AbstractSingleHeuristic {

    private final static int RELATIVE_VALUE = 1;

    public static SingleColumnHeuristic newSingleColumnHeuristic() {
        return new SingleColumnHeuristic(RELATIVE_VALUE);
    }


    @Override
    public Set<Integer> moves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent) {

        Set<Integer> returnMoves = new HashSet<>();

        // First Col
        if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b001001001, (short) 0b00000001) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b001001001, (short) 0b00000000)) {

            returnMoves.add(3);
            returnMoves.add(6);
        } else if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(), (short) 0b001001001, (short) 0b00001000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(), (short) 0b001001001, (short) 0b00000000)) {

            returnMoves.add(0);
            returnMoves.add(6);
        } else if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(), (short) 0b001001001, (short) 0b001000000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(), (short) 0b001001001, (short) 0b00000000)) {

            returnMoves.add(0);
            returnMoves.add(3);
        }

        // Middle Column
        if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b010010010, (short) 0b00000010) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b010010010, (short) 0b00000000)) {

            returnMoves.add(4);
            returnMoves.add(7);
        } else if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(), (short) 0b010010010, (short) 0b00010000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(), (short) 0b010010010, (short) 0b00000000)) {

            returnMoves.add(1);
            returnMoves.add(7);
        } else if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(), (short) 0b010010010, (short) 0b010000000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(), (short) 0b010010010, (short) 0b00000000)) {

            returnMoves.add(1);
            returnMoves.add(4);
        }

        // Last Column
        if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer), (short) 0b100100100, (short) 0b000000100) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent), (short) 0b100100100, (short) 0b00000000)) {

            returnMoves.add(5);
            returnMoves.add(8);
        } else if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(), (short) 0b100100100, (short) 0b00100000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(), (short) 0b100100100, (short) 0b00000000)) {

            returnMoves.add(2);
            returnMoves.add(8);
        } else if (mask(tictactoeBoard.generatePlayerRepresentation(activePlayer).shortValue(), (short) 0b100100100, (short) 0b100000000) &&
                mask(tictactoeBoard.generatePlayerRepresentation(opponent).shortValue(), (short) 0b100100100, (short) 0b00000000)) {

            returnMoves.add(2);
            returnMoves.add(5);
        }

        return returnMoves;
    }

    private SingleColumnHeuristic(int relativeValue) {
        super(relativeValue);

    }

}
