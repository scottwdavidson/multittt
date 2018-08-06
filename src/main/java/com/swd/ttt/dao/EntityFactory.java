package com.swd.ttt.dao;

import com.swd.ttt.entity.play.GameState;
import com.swd.ttt.entity.play.Player;

import java.util.List;

public class EntityFactory {

    public static com.swd.ttt.entity.play.Board generateBoardEntity(Board boardDO) {

        com.swd.ttt.entity.play.Score scoreEntity = generateScoreEntity(boardDO.getScore());
        com.swd.ttt.entity.play.Board boardEntity = com.swd.ttt.entity.play.Board.initialBoard(
                boardDO.getBoardId(),
                boardDO.getMoveNumber(),
                Player.valueOf(boardDO.getActivePlayer()),
                boardDO.getActiveTicTacToeBoardIndex(),
                scoreEntity,
                GameState.valueOf(boardDO.getGameState()),
                Player.valueOf(boardDO.getWinningPlayer()));

        int index = 0;
        for(TicTacToeBoard ticTacToeBoardDO : boardDO.getTttBoards()){
            boardEntity.getTttBoards()[index] = generateTttBoardEntity(ticTacToeBoardDO);
            index++;
        }

        return boardEntity;
    }

    protected static com.swd.ttt.entity.play.Score generateScoreEntity(Score scoreDO) {

        com.swd.ttt.entity.play.Score scoreEntity = com.swd.ttt.entity.play.Score.newScore();
        for (int cats = 0; cats < scoreDO.getCats(); cats++) {
            scoreEntity.plusCats();
        }
        for (int xWins = 0; xWins < scoreDO.getCats(); xWins++) {
            scoreEntity.plusX();
        }
        for (int oWins = 0; oWins < scoreDO.getCats(); oWins++) {
            scoreEntity.plusO();
        }

        return scoreEntity;
    }

//    protected static void initializeTttBoardsList(com.swd.ttt.entity.play.TicTacToeBoard[] ticTacToeBoardEntities, List<TicTacToeBoard> ticTacToeBoardList) {
//
//        for (com.swd.ttt.entity.play.TicTacToeBoard ticTacToeBoardEntity : ticTacToeBoardEntities) {
//            ticTacToeBoardList.add(generateTttBoardDO(ticTacToeBoardEntity));
//        }
//
//    }

    protected static com.swd.ttt.entity.play.TicTacToeBoard generateTttBoardEntity(TicTacToeBoard ticTacToeBoardDO) {

        // Use two factory methods to create and then set the state on the entity TicTacToeBoard object
        com.swd.ttt.entity.play.TicTacToeBoard ticTacToeBoardEntity =
                com.swd.ttt.entity.play.TicTacToeBoard.emptyTicTacToeBoard(ticTacToeBoardDO.getIndex());
        ticTacToeBoardEntity = com.swd.ttt.entity.play.TicTacToeBoard.updateGameState(ticTacToeBoardEntity,
                GameState.valueOf(ticTacToeBoardDO.getGameState()),
                Player.valueOf(ticTacToeBoardDO.getWinningPlayer()));

        // Directly manipulate the Cell array of the entity TicTacToeBoard object
        int index = 0;
        for (Cell cellDO : ticTacToeBoardDO.getCells()) {
            ticTacToeBoardEntity.getCells()[index] = generateCellEntity(cellDO);
            index++;
        }

        return ticTacToeBoardEntity;
    }

    protected static com.swd.ttt.entity.play.Cell generateCellEntity(Cell cellDO) {

        com.swd.ttt.entity.play.Cell cellEntity = com.swd.ttt.entity.play.Cell.newCell(Player.valueOf(cellDO.getPlayer()),
                cellDO.getMoveNumber());
        return cellEntity;
    }

}
