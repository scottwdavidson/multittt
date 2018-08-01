package com.swd.ttt.entity.play;

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
    
    public int getTicTacToeBoardIndex() {
		return ticTacToeBoardIndex;
	}

	public int getPosition() {
		return position;
	}

	@Override
    public boolean equals(Object o){
        MovePosition comparator = (MovePosition)o;
        return (this.position == comparator.getPosition() && this.ticTacToeBoardIndex == comparator.getTicTacToeBoardIndex());
    }

    @Override
    public int hashCode(){
        int hash = 3;
        hash = 53 * hash + this.position;
        hash = 53 * hash + this.ticTacToeBoardIndex;
        return hash;
    }

    @Override
    public String toString() {
        return "MP{" +
                "ticTacToeBoardIndex=" + ticTacToeBoardIndex +
                ", position=" + position +
                '}';
    }
}
