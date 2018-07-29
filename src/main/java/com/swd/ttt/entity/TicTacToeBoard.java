package com.swd.ttt.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeBoard {

    private final static int NUMBER_OF_CELLS = 9;
    private final static Cell[] EMPTY_CELL_TABLE = new Cell[NUMBER_OF_CELLS];
    private final int index;
    private final GameState gameState;
    private final Player winningPlayer;

    private final Cell[] cells = new Cell[NUMBER_OF_CELLS];

    /**
     * Factory method to create an empty ( new ) Tic Tac Toe board
     */
    public static TicTacToeBoard emptyTicTacToeBoard(int index) {
        return new TicTacToeBoard(index, GameState.Open, Player.None);
    }

    /**
     * Factory method to apply a move to an existing Tic Tac Toe board
     */
    public static TicTacToeBoard applyMove(TicTacToeBoard ticTacToeBoard, Player player, MovePosition movePosition, int moveNumber) {
        return new TicTacToeBoard(ticTacToeBoard.getIndex(),
                ticTacToeBoard.getGameState(),
                ticTacToeBoard.getWinningPlayer(),
                ticTacToeBoard.getCells(),
                player,
                movePosition,
                moveNumber);
    }

    /**
     * Factory method to update the game state on an existing Tic Tac Toe board
     */
    public static TicTacToeBoard updateGameState(TicTacToeBoard ticTacToeBoard, GameState gameState, Player winningPlayer) {
        return new TicTacToeBoard(ticTacToeBoard.getIndex(), gameState, winningPlayer, ticTacToeBoard.getCells());
    }


    public List<MovePosition> movePositions(){

        // TODO Dylan to implement
    	
    	List<MovePosition> moveList = new ArrayList<>();
    	
    	for(int i=0; i<cells.length; i++){
    		if(cells[i].getPlayer() != Player.None){
    			MovePosition newMove = MovePosition.newMovePosition(this.index, i);
    			moveList.add(newMove);
    		}
    	}
    	
        return moveList;
    }

    /**
     * Add a move to the table
     */
    @Deprecated
    public void addMove(Player player, int position, int moveNumber) {

        // Error checks
        if (position < 0 || position > NUMBER_OF_CELLS - 1) {
            throw new IllegalArgumentException("Invalid position ( " + position + ") argument.");
        }

        if (cells[position] != Cell.EMPTY_CELL) {
            throw new IllegalArgumentException("Invalid request, can't overwrite existing move; cell ( " + position +
                    " ) already contains a player assignment (" + cells[position]);
        }

        cells[position] = Cell.newCell(player, moveNumber);
    }

    /**
     * Generates a short integer that represents the current state of the X player on this board.
     */
    public Short generatePlayerRepresentation(Player player) {
        short rep = 0;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].getPlayer() == player) {
                rep += Math.pow(2, i);
            }
        }
        return rep;
    }

    public int getIndex() {
        return index;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinningPlayer() {
        return winningPlayer;
    }

    public Cell[] getCells() {
        return cells;
    }

    private TicTacToeBoard(int index, GameState gameState, Player winningPlayer) {
        this(index, gameState, winningPlayer, EMPTY_CELL_TABLE);
    }

    private TicTacToeBoard(int index, GameState gameState, Player winningPlayer, Cell[] cells) {
        this.index = index;
        this.gameState = gameState;
        this.winningPlayer = winningPlayer;
        for (int i = 0; i < NUMBER_OF_CELLS; i++) {
            this.cells[i] = cells[i];
        }
    }

    private TicTacToeBoard(int index, GameState gameState, Player winningPlayer, Cell[] prototypeCells, Player player, MovePosition movePosition, int moveNumber) {

        this.index = index;
        this.gameState = gameState;
        this.winningPlayer = winningPlayer;
        for (int cellIndex = 0; cellIndex < NUMBER_OF_CELLS; cellIndex++) {
            if (cellIndex == movePosition.getPosition()) {
                this.cells[cellIndex] = Cell.newCell(player, moveNumber);
            } else {
                this.cells[cellIndex] = prototypeCells[cellIndex];
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        boolean firstTime = true;
        for(int i = 0; i<this.cells.length; i++){
            if (firstTime){
                firstTime = false;
            }
            else {
                builder.append(",");
            }
            builder.append(cells[i].getPlayer() + ":" + cells[i].getMoveNumber());
        }
        builder.append("]");
        return "TicTacToeBoard{" +
                "index=" + index +
                ", gameState=" + gameState +
                ", winningPlayer=" + winningPlayer +
                ", cells=" + builder.toString() +
                '}';
    }

    /**
     * Initialize a static empty cell table for the creation of new TicTacToe boards
     */
    static {
        for (int i = 0; i < NUMBER_OF_CELLS; i++) {
            EMPTY_CELL_TABLE[i] = Cell.EMPTY_CELL;
        }
    }
}
