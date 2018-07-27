package com.swd.ttt.entity;

import java.util.List;

public class Board {

    private int id;  // identifies the specific board
    private String gameState;  // TODO This is a business object, so it should use the enumeration ( convert later )
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

    public int activeTttBoard(){

        if ( this.getGameState().equals(GameState.Open.name())) {
            for (TicTacToeBoard tttBoard : this.tttBoards) {
                if (tttBoard.isActive()) {
                    return tttBoard.getIndex();
                }
            }
            throw new IllegalStateException("There are no active TTT boards even though this Board is still active!");
        }
        else {
            throw new IllegalStateException("Don't ask for the active TTT board on a closed board!");
        }
    }

    public List<MovePosition> activeTttBoardMovePositions(){
        return this.tttBoards[activeTttBoard()].movePositions();
    }
}
