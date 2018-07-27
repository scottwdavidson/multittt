package com.swd.ttt.entity;

/**
 * Immutable representation of a proposed move including the index of which TicTacToeBoard board and the position
 * on that TicTacToe board.
 */
public class MovePosition {

    private final int ticTacToeBoardIndex;
    private final int position;

    public static MovePosition newMovePosition(int ticTacToeBoardIndex, int position){
        return new MovePosition(ticTacToeBoardIndex,position);
    }

    private MovePosition(int ticTacToeBoardIndex, int position){
        this.ticTacToeBoardIndex = ticTacToeBoardIndex;
        this.position = position;
    }
}
