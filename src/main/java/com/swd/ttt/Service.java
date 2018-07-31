package com.swd.ttt;

import com.swd.ttt.entity.play.Board;

public interface Service {

    /**
     * Perform a move against the identified board.
     */
    Board move(String boardId, String player, int tictactoeBoardIndex, int boardPosition);

}
