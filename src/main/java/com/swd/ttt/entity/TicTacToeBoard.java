package com.swd.ttt.entity;

public class TicTacToeBoard {

    public static class Cell {
        private Player player = Player.None;

        // there's probably some other stuff we'll need so let's create a class now and we can refactor
        // later if needed
    }

    private boolean open = true;
    private boolean active = false;
    private Player winningPlayer = Player.None;

    private Cell[] cells = new Cell[9];

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

    public Cell[] getCells() {
        return cells;
    }

    public void setCells(Cell[] cells) {
        this.cells = cells;
    }
}
