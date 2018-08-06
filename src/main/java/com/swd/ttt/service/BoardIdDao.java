package com.swd.ttt.service;

import com.swd.ttt.dao.BoardId;
import com.swd.ttt.entity.play.Board;

/**
 * Defines the data access object interface for retrieving the BoardId object
 */
public interface BoardIdDao {

    /**
     * Retrieve the BoardId
     */
    int current();

    /**
     * Increment the BoardId
     */
    int increment();

}
