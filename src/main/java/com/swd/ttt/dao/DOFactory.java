package com.swd.ttt.dao;

import java.util.List;

public class DOFactory {

    public static Board generateBoardDO(com.swd.ttt.entity.play.Board boardEntity) {

        Board board = new Board();

        board.setBoardId(boardEntity.getId());
        board.setMoveNumber(boardEntity.getMoveNumber());
        board.setActivePlayer(boardEntity.getActivePlayer().name());
        board.setActiveTicTacToeBoardIndex(boardEntity.getActiveTicTacToeBoardIndex());
        board.setScore(generateScoreDO(boardEntity.getScore()));
        board.setGameState(boardEntity.getGameState().name());
        board.setWinningPlayer(boardEntity.getWinningPlayer().name());

        for(com.swd.ttt.entity.play.TicTacToeBoard ticTacToeBoardEntity: boardEntity.getTttBoards()){
            board.getTttBoards().add(generateTttBoardDO(ticTacToeBoardEntity));
        }
        return board;

    }

    protected static Score generateScoreDO(com.swd.ttt.entity.play.Score scoreEntity) {

        Score score = new Score();
        score.setCats(scoreEntity.getCats());
        score.setxWins(scoreEntity.getxWins());
        score.setoWins(scoreEntity.getoWins());
        return score;
    }

    protected static void initializeTttBoardsList(com.swd.ttt.entity.play.TicTacToeBoard[] ticTacToeBoardEntities, List<TicTacToeBoard> ticTacToeBoardList) {

        for (com.swd.ttt.entity.play.TicTacToeBoard ticTacToeBoardEntity : ticTacToeBoardEntities) {
            ticTacToeBoardList.add(generateTttBoardDO(ticTacToeBoardEntity));
        }

    }

    protected static TicTacToeBoard generateTttBoardDO(com.swd.ttt.entity.play.TicTacToeBoard ticTacToeBoardEntity) {

        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
        ticTacToeBoard.setIndex(ticTacToeBoardEntity.getIndex());
        ticTacToeBoard.setGameState(ticTacToeBoardEntity.getGameState().name());
        ticTacToeBoard.setWinningPlayer(ticTacToeBoardEntity.getWinningPlayer().name());

        for (com.swd.ttt.entity.play.Cell cellEntity : ticTacToeBoardEntity.getCells()) {
            ticTacToeBoard.getCells().add(generateCellDO(cellEntity));
        }
        return ticTacToeBoard;
    }

    protected static Cell generateCellDO(com.swd.ttt.entity.play.Cell cellEntity) {

        Cell cell = new Cell();
        cell.setPlayer(cellEntity.getPlayer().name());
        cell.setMoveNumber(cellEntity.getMoveNumber());
        return cell;
    }

}
