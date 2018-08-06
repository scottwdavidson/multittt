package com.swd.ttt.dao;

import com.swd.ttt.entity.play.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the overall playing board for the Multi Tic Tac Toe game.
 */
@Document(collection = "board")
public class Board {

    @Id
    private ObjectId id;
    private int boardId;
    private int moveNumber;
    private String activePlayer;
    private int activeTicTacToeBoardIndex;
    private Score score;
    private String gameState;
    private String winningPlayer;
    private List<TicTacToeBoard> tttBoards = new ArrayList<>();

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public String getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(String activePlayer) {
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

    public List<TicTacToeBoard> getTttBoards() {
        return tttBoards;
    }

    public void setTttBoards(List<TicTacToeBoard> tttBoards) {
        this.tttBoards = tttBoards;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", moveNumber=" + moveNumber +
                ", activePlayer='" + activePlayer + '\'' +
                ", activeTicTacToeBoardIndex=" + activeTicTacToeBoardIndex +
                ", score=" + score +
                ", gameState='" + gameState + '\'' +
                ", winningPlayer='" + winningPlayer + '\'' +
                ", tttBoards=" + tttBoards +
                '}';
    }
}
