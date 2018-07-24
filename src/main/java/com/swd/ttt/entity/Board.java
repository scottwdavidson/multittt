package com.swd.ttt.entity;

public class Board {

    private int id;  // identifies the specific board
    private String gameState;
    private Player activePlayer = Player.None;
    private Player winningPlayer = Player.None;
    private TicTacToeBoard[] tttBoards = new TicTacToeBoard[9];

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Player getWinningPlayer() {
        return winningPlayer;
    }

    public void setWinningPlayer(Player winningPlayer) {
        this.winningPlayer = winningPlayer;
    }

    public TicTacToeBoard[] getTttBoards() {
        return tttBoards;
    }

    public void setTttBoards(TicTacToeBoard[] tttBoards) {
        this.tttBoards = tttBoards;
    }
}
