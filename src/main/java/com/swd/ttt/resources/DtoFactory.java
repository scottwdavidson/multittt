package com.swd.ttt.resources;

/**
 * Factory class that generates DTOs ( Data Transfer Objects ) from Business Objects.
 */
public class DtoFactory {

    public static Board generateTicTacToeBoardDto(com.swd.ttt.entity.Board boardEntity) {

        Board board = new Board();

        board.setGameId(String.valueOf(boardEntity.getId())); // TODO Need to decide on board id
        board.setMoveNumber(deriveCurrentMoveNumber(boardEntity));
        board.setGameState(boardEntity.getGameState().name());
        board.setWinner(boardEntity.getWinningPlayer().name());
        for(com.swd.ttt.entity.TicTacToeBoard ticTacToeBoardEntity : boardEntity.getTttBoards()){
            board.getTictactoes().add(generateTicTacToeBoardDto(ticTacToeBoardEntity));
        }

        return board;
    }

    protected static int deriveCurrentMoveNumber(com.swd.ttt.entity.Board boardEntity){
        return 22; // TODO Implement this method
    }

    public static TicTacToeBoard generateTicTacToeBoardDto(com.swd.ttt.entity.TicTacToeBoard ticTacToeBoardEntity) {

        TicTacToeBoard ticTacToeBoardDto = new TicTacToeBoard();

        ticTacToeBoardDto.setGameState(ticTacToeBoardEntity.getGameState().name());
        ticTacToeBoardDto.setWinner(ticTacToeBoardEntity.getWinningPlayer().name());
        int position = 0;
        for (com.swd.ttt.entity.Cell cell : ticTacToeBoardEntity.getCells()) {
            ticTacToeBoardDto.getCells().add(generateCellDto(position, cell));
            position++;
        }

        return ticTacToeBoardDto;
    }

    public static TicTacToeBoard.Cell generateCellDto(int position, com.swd.ttt.entity.Cell cellEntity) {

        TicTacToeBoard.Cell cellDto = new TicTacToeBoard.Cell();

        cellDto.setPosition(position);
        cellDto.setPlayer(cellEntity.getPlayer().name());
        cellDto.setMoveNumber(cellEntity.getMoveNumber());

        return cellDto;
    }
}
