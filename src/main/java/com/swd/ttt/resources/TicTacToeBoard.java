package com.swd.ttt.resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an individual Tic Tac Toe board in it's current state.
 */
public class TicTacToeBoard {

    public static class Cell {
        private int position;
        private String player;
        private int moveNumber = -1;

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

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
    private String gameState; // "Open" or "Closed"
    private String winner; // "X", "O" or "None"
    private boolean active;

    /**
     * Provides validity checks on the current object
     */
    public boolean isValid() {

        // Number of cells
        if ( 9 != this.cells.size() ) {
            System.out.println("Validity Check Failure: Number of cells should be 9, it is: " + this.cells.size());
            return false;
        }

        if ( GameState.Open.name().equals(this.gameState) && this.winner != Player.None.name()){
            System.out.println("Validity Check Failure: Game state is Open but winner is selected: " + this.winner);
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

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
