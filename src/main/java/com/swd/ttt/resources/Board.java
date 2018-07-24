package com.swd.ttt.resources;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private String gameId;
    private int moveNumber;
    private String gameState; // "Open" or "Closed"
    private String winner; // "X", "O" or "None"
    private List<TicTacToeBoard> tictactoes = new ArrayList<TicTacToeBoard>();

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
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

    public List<TicTacToeBoard> getTictactoes() {
        return tictactoes;
    }

    public void setTictactoes(List<TicTacToeBoard> tictactoes) {
        this.tictactoes = tictactoes;
    }
}
