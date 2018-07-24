package com.swd.ttt.resources;

import com.swd.ttt.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Helper class to handle the basic delegation of this request to the *Interactor*.
 */
public class TttResourceHelper {

    @Autowired
    Service service;

    public Board move(String boardId, Move move) {

        try {

            throw new IllegalArgumentException("Testing IAE ... ");
//            com.swd.ttt.entity.Board boardEntity = this.service.move(boardId, move.getPlayer(), move.getTictactoeBoardIndex(), move.getBoardPosition());
//            return DtoFactory.generateTicTacToeBoardDto(boardEntity);

        } catch (Throwable cause) {

            throw new WebApplicationException(cause.getMessage(), cause, Response.status(
                    Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }
}
