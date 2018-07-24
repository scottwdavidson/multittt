package com.swd.ttt.resources;

public class Move {

    private String player;
    private int tictactoeBoardIndex;
    private int boardPosition;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getTictactoeBoardIndex() {
        return tictactoeBoardIndex;
    }

    public void setTictactoeBoardIndex(int tictactoeBoardIndex) {
        this.tictactoeBoardIndex = tictactoeBoardIndex;
    }

    public int getBoardPosition() {
        return boardPosition;
    }

    public void setBoardPosition(int boardPosition) {
        this.boardPosition = boardPosition;
    }
}
