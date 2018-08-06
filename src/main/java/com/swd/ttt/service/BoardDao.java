package com.swd.ttt.service;

import com.swd.ttt.entity.play.Board;

/**
 * Defines the data access object interface for persisting and retrieving Board objects
 */
public interface BoardDao {

    /**
     * Persist the provided Board.
     */
    void persist(Board board);

    /**
     * Retrieve the requested Board ( the latest played )
     */
    Board retrieve(int id);

    /**
     * Get the latest move number from the provided game id
     */
    int latestMoveNumber(int id);
}
