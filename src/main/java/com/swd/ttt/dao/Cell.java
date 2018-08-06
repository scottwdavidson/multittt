package com.swd.ttt.dao;

public class Cell {

    private  String player;
    private  int moveNumber;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "player='" + player + '\'' +
                ", moveNumber=" + moveNumber +
                '}';
    }
}
