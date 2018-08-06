package com.swd.ttt.dao;


import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard {

    private  int index;
    private  String gameState;
    private  String winningPlayer;
    private List<Cell> cells = new ArrayList<>();

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public String getWinningPlayer() {
        return winningPlayer;
    }

    public void setWinningPlayer(String winningPlayer) {
        this.winningPlayer = winningPlayer;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        return "TicTacToeBoard{" +
                "index=" + index +
                ", gameState='" + gameState + '\'' +
                ", winningPlayer='" + winningPlayer + '\'' +
                ", cells=" + cells +
                '}';
    }
}
