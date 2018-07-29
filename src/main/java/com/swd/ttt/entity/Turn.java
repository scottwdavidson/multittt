package com.swd.ttt.entity;

/**
 * Represents the function of executing a "turn" in the game, collecting all of the intrinsic
 * required actions into a single place. The input is a MovePosition and a Board and the output is the
 * *next* Board with the provided move executed.
 */
public class Turn {

    public static Board executeTurn(MovePosition movePosition, final Board board) {

        // Update the TicTacToeBoard first
        int moveNumber = board.getMoveNumber() + 1;
        TicTacToeBoard updatedTicTacToeBoard = TicTacToeBoard.applyMove(
                board.getTttBoards()[movePosition.getTicTacToeBoardIndex()],
                board.getActivePlayer(),
                movePosition,
                moveNumber);

        // If move resulted in a *win* or *cats* game, update the TicTacToeBoard, e.g. :
//        updatedTicTacToeBoard = TicTacToeBoard.updateGameState(updatedTicTacToeBoard, GameState.Closed,board.getActivePlayer());

        // Update the board
        Player opponent = board.getActivePlayer().opponent();
        int updatedTicTacToeBoardIndex = movePosition.getTicTacToeBoardIndex();
        int activeTicTacToeBoardIndex = movePosition.getPosition(); // TODO create a helper method b/c of closed TTT boards
        Board updatedBoard = board.executeTurn(
                moveNumber,
                opponent,
                updatedTicTacToeBoardIndex,
                updatedTicTacToeBoard,
                activeTicTacToeBoardIndex,
                board.getScore());

        return updatedBoard;
    }
}
