package com.swd.ttt.resources;

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

    private final TttResourceHelper tttResourceHelper = new TttResourceHelper();

    @GET
    @Path("/hello")
    public String hello(){
        return "Hello --- from DEMO !!";
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
}
