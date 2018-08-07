package com.swd.ttt.dao;

import com.swd.ttt.entity.play.Board;
import com.swd.ttt.service.BoardDao;

public class InMemoryBoardDao implements BoardDao {

    @Override
    public void persist(Board board) {

    }

    @Override
    public Board retrieve(int id) {
        return null;
    }

    @Override
    public int latestMoveNumber(int id) {
        return 0;
    }
}
