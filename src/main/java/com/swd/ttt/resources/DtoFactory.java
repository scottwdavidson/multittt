package com.swd.ttt.resources;

import com.swd.ttt.entity.play.Cell;

/**
 * Factory class that generates DTOs ( Data Transfer Objects ) from Business Objects.
 */
public class DtoFactory {

    public static Board generateBoardDto(com.swd.ttt.entity.play.Board boardEntity) {

        Board board = new Board();

        board.setGameId(String.valueOf(boardEntity.getId())); // TODO Need to decide on board id
        board.setMoveNumber(deriveCurrentMoveNumber(boardEntity));
        board.setActivePlayer(boardEntity.getActivePlayer().name());
        board.setActiveTicTacToeBoardIndex(boardEntity.getActiveTicTacToeBoardIndex());
        board.setScore(generateScoreDto(boardEntity.getScore()));
        board.setGameState(boardEntity.getGameState().name());
        board.setWinner(boardEntity.getWinningPlayer().name());
        for(com.swd.ttt.entity.play.TicTacToeBoard ticTacToeBoardEntity : boardEntity.getTttBoards()){
            board.getTictactoes().add(generateTicTacToeBoardDto(ticTacToeBoardEntity));
        }

        return board;
    }

    protected static int deriveCurrentMoveNumber(com.swd.ttt.entity.play.Board boardEntity){
        return boardEntity.getMoveNumber();
    }

    public static TicTacToeBoard generateTicTacToeBoardDto(com.swd.ttt.entity.play.TicTacToeBoard ticTacToeBoardEntity) {

        TicTacToeBoard ticTacToeBoardDto = new TicTacToeBoard();

        ticTacToeBoardDto.setIndex(ticTacToeBoardEntity.getIndex());
        ticTacToeBoardDto.setGameState(ticTacToeBoardEntity.getGameState().name());
        ticTacToeBoardDto.setWinningPlayer(ticTacToeBoardEntity.getWinningPlayer().name());
        for (Cell cell : ticTacToeBoardEntity.getCells()) {
            ticTacToeBoardDto.getCells().add(generateCellDto(cell));
        }

        return ticTacToeBoardDto;
    }

    public static TicTacToeBoard.Cell generateCellDto(Cell cellEntity) {

        TicTacToeBoard.Cell cellDto = new TicTacToeBoard.Cell();

        cellDto.setPlayer(cellEntity.getPlayer().name());
        cellDto.setMoveNumber(cellEntity.getMoveNumber());

        return cellDto;
    }

    public static Score generateScoreDto(com.swd.ttt.entity.play.Score scoreEntity) {
        return Score.newScore(scoreEntity.getoWins(), scoreEntity.getoWins(), scoreEntity.getCats());
    }

}
