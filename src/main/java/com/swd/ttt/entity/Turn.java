package com.swd.ttt.entity;

import com.swd.ttt.entity.eval.DrawEval;
import com.swd.ttt.entity.eval.WinEval;

/**
 * Represents the function of executing a "turn" in the game, collecting all of the intrinsic
 * required actions into a single place. The input is a MovePosition and a Board and the output is the
 * *next* Board with the provided move executed.
 */
public class Turn {

    // TODO methods should *not* be static - we should be using Spring IOC here to manage singletons instead

    private WinEval winEval = new WinEval();
    private DrawEval drawEval = new DrawEval();


    public Board executeTurn(MovePosition movePosition, final Board board) {

        // Update the TicTacToeBoard first
        int moveNumber = board.getMoveNumber() + 1;
        Player activePlayer = board.getActivePlayer();
        TicTacToeBoard updatedTicTacToeBoard = TicTacToeBoard.applyMove(
                board.getTttBoards()[movePosition.getTicTacToeBoardIndex()],
                board.getActivePlayer(),
                movePosition,
                moveNumber);

        // If move resulted in a *win* or *cats* game, update the TicTacToeBoard and calculate new Score
        Player opponent = board.getActivePlayer().opponent();
        Score possiblyUpdateScore = board.getScore();

        if (winEval.evaluationMatches(updatedTicTacToeBoard, activePlayer, opponent)) {
            updatedTicTacToeBoard = TicTacToeBoard.updateGameState(updatedTicTacToeBoard, GameState.Closed, activePlayer);
            possiblyUpdateScore = possiblyUpdateScore.plus(activePlayer);
        } else if (drawEval.evaluationMatches(updatedTicTacToeBoard, activePlayer, opponent)) {
            updatedTicTacToeBoard = TicTacToeBoard.updateGameState(updatedTicTacToeBoard, GameState.Closed, Player.None);
            possiblyUpdateScore = possiblyUpdateScore.plusCats();
        }

        // Update the board
        int updatedTicTacToeBoardIndex = movePosition.getTicTacToeBoardIndex();
        int updateActiveTicTacToeBoardIndex = determineNextActiveTicTacToeBoardIndex(possiblyUpdateScore,board,updatedTicTacToeBoard,movePosition);

        Board updatedBoard = board.executeTurn(
                moveNumber,
                opponent,
                updatedTicTacToeBoardIndex,
                updatedTicTacToeBoard,
                updateActiveTicTacToeBoardIndex,
                possiblyUpdateScore);

        if (possiblyUpdateScore.gameIsOver()) {
            updatedBoard = updatedBoard.gamesOver(possiblyUpdateScore, GameState.Closed, possiblyUpdateScore.winningPlayer());
        }

        return updatedBoard;
    }

    /**
     * Determine what the next active TTT board should be. In general, this is simply the position played previously
     * which we get from the MovePosition argument. But, if that position points to a TTT board which is CLOSED, then
     * we must search to find the next, sequential TTT board. To further complicate things, one of the board argument's
     * TTT boards has been updated, so we need to properly identify it to get the most update to date status from it.
     */
    protected int determineNextActiveTicTacToeBoardIndex(Score score, Board board, TicTacToeBoard updatedTicTacToeBoard, MovePosition movePosition){

        // First, check the score - if the game is over, then just return the move position
        if(score.gameIsOver()){
            return movePosition.getPosition();
        }

        int initialIndex = movePosition.getPosition();
        int currentIndex = initialIndex;
        do {

            // Find the first board in order which is Open
            if (currentIndex == updatedTicTacToeBoard.getIndex()) {
                if (updatedTicTacToeBoard.getGameState() == GameState.Open) {
                    return currentIndex;
                }
            }
            else if ( board.getTttBoards()[currentIndex].getGameState() == GameState.Open ){
                return currentIndex;
            }

            currentIndex = (currentIndex + 1) % updatedTicTacToeBoard.getCells().length;
        } while ( currentIndex != initialIndex );

        // Should never get here, if you did then there's an error b/c the game should be over
        throw new IllegalStateException("Game appears to be over as the next active tic tac toe board index could be determined, yet provided score contradicts that. ");

    }

}
