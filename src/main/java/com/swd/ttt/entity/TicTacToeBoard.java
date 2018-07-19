package com.swd.ttt.entity;

import static com.swd.ttt.entity.TicTacToeBoard.Cell.EMPTY_CELL;

public class TicTacToeBoard {

    /**
     * Immutable representation of the cell of a Tic Tac Toe board which holds the value of
     * a single player ( X, O or None )
     */
    public static class Cell {

        private final Player player;

        public static Cell EMPTY_CELL = newCell(Player.None);
        public static Cell X_CELL = newCell(Player.X);
        public static Cell O_CELL = newCell(Player.O);

        public static Cell newCell(Player player) {

            // TODO consider a player check which returns one of the static Cell instances
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

    private final static int NUMBER_OF_CELLS = 9;
    private boolean open = true;
    private boolean active = false;
    private Player winningPlayer = Player.None;

    private final Cell[] cells = new Cell[NUMBER_OF_CELLS];

    public static TicTacToeBoard emptyTicTacToeBoard() {
        return new TicTacToeBoard();
    }

    public static TicTacToeBoard prototypeTicTacToeBoard(TicTacToeBoard prototype) {
        TicTacToeBoard newTicTacToeBoard = new TicTacToeBoard();
        for (int i = 0; i < NUMBER_OF_CELLS; i++) {
            newTicTacToeBoard.getCells()[i] = prototype.getCells()[i];
        }
        return newTicTacToeBoard;
    }

    /**
     * Add a move to the table
     */
    public void addMove(Player player, int position) {

        // Error checks
        if (position < 0 || position > NUMBER_OF_CELLS - 1) {
            throw new IllegalArgumentException("Invalid position ( " + position + ") argument.");
        }

        if (cells[position] != EMPTY_CELL) {
            throw new IllegalArgumentException("Invalid request, can't overwrite existing move; cell ( " + position +
                    " ) already contains a player assignment (" + cells[position]);
        }

        cells[position] = Cell.newCell(player);
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

    private TicTacToeBoard() {
        for (int i = 0; i < NUMBER_OF_CELLS; i++) {
            this.cells[i] = EMPTY_CELL;
        }
    }

}
