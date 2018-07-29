package com.swd.ttt.entity;

import java.util.List;

/**
 * Represents the overall playing board for the Multi Tic Tac Toe game.
 */
public class Board {

    private int id;       // identifies the specific board
    private int moveNumber;   // identifies the specific version ( based on which move ) of the board
    private Player activePlayer = Player.None;
    private int activeTicTacToeBoardIndex = 0;
    private Score score = Score.newScore();
    private GameState gameState = GameState.Open;
    private Player winningPlayer = Player.None;
    private TicTacToeBoard[] tttBoards = new TicTacToeBoard[9];

    // TODO Create a factory method to create an initial board ( id and moveNumber should probably be immutable )
    /**
     * Creates a new Board, updating properties as specified by the arguments. Call the overloaded version which requires the Score.
     */
    public Board executeTurn(int moveId, Player activePlayer, int updatedTicTacToeBoardIndex, TicTacToeBoard updatedTicTacToeBoard, int activeTicTacToeBoardIndex) {
        return executeTurn(moveId, activePlayer, updatedTicTacToeBoardIndex, updatedTicTacToeBoard, activeTicTacToeBoardIndex, this.getScore());
    }

    /**
     * Creates a new Board, updating properties as specified by the arguments.
     */
    public Board executeTurn(int moveNumber, Player activePlayer, int updatedTicTacToeBoardIndex, TicTacToeBoard updatedTicTacToeBoard, int activeTicTacToeBoardIndex, Score score) {

        Board evolvedBoard = new Board();

        // Directly set values
        evolvedBoard.setId(this.getId());
        evolvedBoard.setMoveNumber(moveNumber);
        evolvedBoard.setActivePlayer(activePlayer);
        evolvedBoard.setActiveTicTacToeBoardIndex(activeTicTacToeBoardIndex);
        evolvedBoard.setScore(score);
        evolvedBoard.setGameState(this.getGameState());
        evolvedBoard.setWinningPlayer(this.getWinningPlayer());

        // Update TTT board related items
        for (int index = 0; index < this.getTttBoards().length; index++) {

            // Copy the correct board into the new ( evolved ) Tic Tac Toe Board
            if (index == updatedTicTacToeBoardIndex) {
                evolvedBoard.getTttBoards()[index] = updatedTicTacToeBoard;
            } else {
                evolvedBoard.getTttBoards()[index] = this.getTttBoards()[index];
            }
        }
        return evolvedBoard;

    }

    public void gamesOver(Score score, GameState gameState, Player winningPlayer) {
        this.score = score;
        this.gameState = gameState;
        this.winningPlayer = winningPlayer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public int getActiveTicTacToeBoardIndex() {
        return activeTicTacToeBoardIndex;
    }

    public void setActiveTicTacToeBoardIndex(int activeTicTacToeBoardIndex) {
        this.activeTicTacToeBoardIndex = activeTicTacToeBoardIndex;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
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

    public int getActiveTttBoard() {

        if (this.getGameState().equals(GameState.Open.name())) {
            return this.activeTicTacToeBoardIndex;
        } else {
            throw new IllegalStateException("Don't ask for the active TTT board on a closed board!");
        }
    }

    public void setActiveTttBoard(int activeTicTacToeBoard) {
        this.activeTicTacToeBoardIndex = activeTicTacToeBoard;
    }

    public List<MovePosition> activeTttBoardMovePositions() {
        return this.tttBoards[getActiveTttBoard()].movePositions();
    }

}
