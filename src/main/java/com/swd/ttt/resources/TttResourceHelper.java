package com.swd.ttt.resources;

import com.swd.ttt.Helper;
import com.swd.ttt.Service;
import com.swd.ttt.entity.play.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Helper class to handle the basic delegation of this request to the *Interactor*.
 */
@Component
public class TttResourceHelper implements Helper {

    @Autowired
    private Service service;

    public Board move(String boardId, Move move) {

        try {

            com.swd.ttt.entity.play.Board boardEntity = this.service.move(boardId, move.getPlayer(), move.getTictactoeBoardIndex(), move.getBoardPosition());
            return DtoFactory.generateBoardDto(boardEntity);

//            throw new IllegalArgumentException("Testing IAE ... ");
//            com.swd.ttt.entity.play.Board boardEntity = this.service.move(boardId, move.getPlayer(), move.getTictactoeBoardIndex(), move.getBoardPosition());
//            return DtoFactory.generateTicTacToeBoardDto(boardEntity);

        } catch (Throwable cause) {

            throw new WebApplicationException(cause.getMessage(), cause, Response.status(
                    Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }

    public Board newGame(int activeTicTacToeBoard) {
        com.swd.ttt.entity.play.Board boardEntity = this.service.newGame(activeTicTacToeBoard);
        return DtoFactory.generateBoardDto(boardEntity);
    }

    public Board getLatest(int boardId) {

        try {

            com.swd.ttt.entity.play.Board boardEntity = this.service.getLatest(boardId);
            return DtoFactory.generateBoardDto(boardEntity);

//            throw new IllegalArgumentException("Testing IAE ... ");
//            com.swd.ttt.entity.play.Board boardEntity = this.service.move(boardId, move.getPlayer(), move.getTictactoeBoardIndex(), move.getBoardPosition());
//            return DtoFactory.generateTicTacToeBoardDto(boardEntity);

        } catch (Throwable cause) {

            throw new WebApplicationException(cause.getMessage(), cause, Response.status(
                    Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }

}
