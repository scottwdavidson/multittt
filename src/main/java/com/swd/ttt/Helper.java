package com.swd.ttt;

import com.swd.ttt.resources.Board;
import com.swd.ttt.resources.Move;
import org.springframework.stereotype.Component;

public interface Helper {

    Board move(String boardId, Move move);

    Board newGame(int activeTicTacToeBoard);

    Board getLatest(int boardId);

}
