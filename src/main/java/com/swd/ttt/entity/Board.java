package com.swd.ttt.entity;

import java.util.Arrays;
import java.util.List;

/**
 * Represents the overall playing board for the Multi Tic Tac Toe game.
 */
public class Board {

    private final int id;       // identifies the specific board
    private final int moveNumber;   // identifies the specific version ( based on which move ) of the board
    private final Player activePlayer;
    private final int activeTicTacToeBoardIndex;
    private final Score score;
    private final GameState gameState;
    private final Player winningPlayer;
    private final TicTacToeBoard[] tttBoards = new TicTacToeBoard[9];

    // TODO Create a factory method to create an initial board ( id and moveNumber should probably be immutable )

    /**
     * Factory method for creating the initial board
     */
    public static Board initialBoard(int id, Player activePlayer, int activeTicTacToeBoardIndex) {
        Board initialBoard = new Board(id, activePlayer, activeTicTacToeBoardIndex);

        for (int index = 0; index < initialBoard.getTttBoards().length; index++) {
            initialBoard.getTttBoards()[index] = TicTacToeBoard.emptyTicTacToeBoard(index);
        }
        return initialBoard;
    }

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

        Board evolvedBoard = new Board(this.getId(), moveNumber, activePlayer, activeTicTacToeBoardIndex, score, this.getGameState(), this.winningPlayer);

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

    public Board gamesOver(Score score, GameState gameState, Player winningPlayer) {

        Board gamesOverBoard = new Board(this.getId(), this.getMoveNumber(), this.getActivePlayer(), this.activeTicTacToeBoardIndex, score, gameState, winningPlayer);

        // Copy the TTT boards
        for (int index = 0; index < this.getTttBoards().length; index++) {
            gamesOverBoard.getTttBoards()[index] = this.getTttBoards()[index];
        }
        return gamesOverBoard;
    }

    public int getId() {
        return id;
    }


    public int getMoveNumber() {
        return moveNumber;
    }


    public Player getActivePlayer() {
        return activePlayer;
    }


    public int getActiveTicTacToeBoardIndex() {
        return activeTicTacToeBoardIndex;
    }


    public Score getScore() {
        return score;
    }

    public GameState getGameState() {
        return gameState;
    }


    public Player getWinningPlayer() {
        return winningPlayer;
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

    public List<MovePosition> activeTttBoardMovePositions() {
        return this.tttBoards[getActiveTttBoard()].movePositions();
    }

    private Board(int id, Player activePlayer, int activeTicTacToeBoardIndex) {
        this(id, 0, activePlayer, activeTicTacToeBoardIndex, Score.newScore(), GameState.Open, Player.None);
    }

    private Board(int id, int moveNumber, Player activePlayer, int activeTicTacToeBoardIndex, Score score, GameState gameState, Player winningPlayer) {
        this.id = id;
        this.moveNumber = moveNumber;
        this.activePlayer = activePlayer;
        this.activeTicTacToeBoardIndex = activeTicTacToeBoardIndex;
        this.score = score;
        this.gameState = gameState;
        this.winningPlayer = winningPlayer;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", moveNumber=" + moveNumber +
                ", activePlayer=" + activePlayer +
                ", activeTicTacToeBoardIndex=" + activeTicTacToeBoardIndex +
                ", score=" + score +
                ", gameState=" + gameState +
                ", winningPlayer=" + winningPlayer +
                ", tttBoards=" + Arrays.toString(tttBoards) +
                '}';
    }
}
