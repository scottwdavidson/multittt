package com.swd.ttt;

import com.swd.ttt.entity.play.Board;
import org.springframework.beans.factory.annotation.Autowired;

public interface Service {

    /**
     * Generate new game Board
     */
    Board newGame(int activeTicTacToeBoard);

    /**
     * Perform a move against the identified board.
     */
    Board move(String boardId, String player, int tictactoeBoardIndex, int boardPosition);

    /**
     * Get the latest board for the provided id
     */
    Board getLatest(int boardId);

}
