package com.swd.ttt.entity;

import java.util.Arrays;
import java.util.List;

import static com.swd.ttt.entity.TicTacToeBoard.Cell.EMPTY_CELL;

public class TicTacToeBoard {

    public static class Cell {

        private final Player player;

        public static Cell EMPTY_CELL = newCell(Player.None);

        public static Cell newCell(Player player){
            return new Cell(player);
        }

        public Player getPlayer() {
            return player;
        }

        private Cell(Player player) {
            this.player = player;
        }


        // there's probably some other stuff we'll need so let's create a class now and we can refactor
        // later if needed
    }

    private boolean open = true;
    private boolean active = false;
    private Player winningPlayer = Player.None;

    private final Cell[] cells = new Cell[9];

    public static TicTacToeBoard emptyTicTacToeBoard(){
        return new TicTacToeBoard();
    }

    /**
     * Add a move to the table
     */
    public void addMove(Player player, int position){

        // Error checks
        if (position < 0 || position > 8) {
            throw new IllegalArgumentException("Invalid position ( " + position + ") argument.");
        }

        if (cells[position] != EMPTY_CELL){
            throw new IllegalArgumentException("Invalid request, can't overwrite existing move; cell ( " + position +
                    " ) already contains a player assignment (" + cells[position]);
        }

        cells[position] = Cell.newCell(player);
    }

    /**
     * Generates a short integer that represents the current state of the X player on this board.
     */
    public Short generateXRepresentation() {
        return 0;
    }

    /**
     * Generates a short integer that represents the current state of the O player on this board.
     */
    public Short generateORepresentation() {
        return 0;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Player getWinningPlayer() {
        return winningPlayer;
    }

    public void setWinningPlayer(Player winningPlayer) {
        this.winningPlayer = winningPlayer;
    }

    public final Cell[] getCells() {
        return cells;
    }

    private TicTacToeBoard(){
        for(int i = 0; i<9; i++){
            this.cells[i] = EMPTY_CELL;
        }
    }

}
