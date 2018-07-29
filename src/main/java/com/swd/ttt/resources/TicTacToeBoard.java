package com.swd.ttt.resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an individual Tic Tac Toe board in it's current state.
 */
public class TicTacToeBoard {

    public static class Cell {
        private String player;
        private int moveNumber = -1;

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
    }

    private List<Cell> cells = new ArrayList<Cell>();
    private int index;
    private String gameState; // "Open" or "Closed"
    private String winningPlayer; // "X", "O" or "None"

    /**
     * Provides validity checks on the current object
     */
    public boolean isValid() {

        // Number of cells
        if ( 9 != this.cells.size() ) {
            System.out.println("Validity Check Failure: Number of cells should be 9, it is: " + this.cells.size());
            return false;
        }

        if ( GameState.Open.name().equals(this.gameState) && this.getWinningPlayer() != Player.None.name()){
            System.out.println("Validity Check Failure: Game state is Open but winner is selected: " + this.getWinningPlayer());
            return false;
        }

        return true;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

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
}
