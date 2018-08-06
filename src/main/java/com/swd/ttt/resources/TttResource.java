package com.swd.ttt.resources;

import com.swd.ttt.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RestController
@Path("/")
public class TttResource {

    @Autowired
    private Helper tttResourceHelper;

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String hello(){
        return "Hello --- from DEMO !!";
    }

    @GET
    @Path("/boards/{activeTicTacToeBoard}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Board newGame(@PathParam("activeTicTacToeBoard") int activeTicTacToeBoard){

        try {
            System.out.println("----- HHHHHEEEEERRRRREEEE ");
            System.out.println("----- HHHHHEEEEERRRRREEEE ");
            System.out.println("----- HHHHHEEEEERRRRREEEE ");
            System.out.println("----- HHHHHEEEEERRRRREEEE ");
            System.out.println("----- HHHHHEEEEERRRRREEEE ");
            return this.tttResourceHelper.newGame(activeTicTacToeBoard);
        } catch ( WebApplicationException wae ){
            throw wae;
        } catch (Throwable cause) {

            throw new WebApplicationException(cause, Response.status(
                    Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }

    @POST
    @Path("/board/{boardId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Board move(@PathParam("boardId") String boardId, Move move){

        try {
            return this.tttResourceHelper.move(boardId, move);
        } catch ( WebApplicationException wae ){
            throw wae;
        } catch (Throwable cause) {

            throw new WebApplicationException(cause, Response.status(
                    Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }

    @GET
    @Path("/board/{boardId}/latest")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Board getLatest(@PathParam("boardId") int boardId){

        try {
            return this.tttResourceHelper.getLatest(boardId);
        } catch ( WebApplicationException wae ){
            throw wae;
        } catch (Throwable cause) {

            throw new WebApplicationException(cause, Response.status(
                    Response.Status.INTERNAL_SERVER_ERROR).build());
        }
    }

}
