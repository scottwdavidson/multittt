package com.swd.ttt.entity;

/**
 * Immutable object representing of a Cell of a Tic Tac Toe Board.
 */
public class Cell {

    private final Player player;
    private final int moveNumber;

    public static Cell EMPTY_CELL = new Cell(Player.None, -1);

    public static Cell newXCell(int moveNumber){
        return new Cell(Player.X, moveNumber);
    }
    public static Cell newOCell(int moveNumber){
        return new Cell(Player.X, moveNumber);
    }

    public static Cell newCell(Player player, int moveNumber){
        return new Cell(player, moveNumber);
    }

    public Player getPlayer() {
        return player;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    private Cell(Player player, int moveNumber) {
        this.player = player;
        this.moveNumber = moveNumber;
    }

}
