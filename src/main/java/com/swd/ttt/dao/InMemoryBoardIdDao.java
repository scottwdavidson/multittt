package com.swd.ttt.dao;

import com.swd.ttt.service.BoardIdDao;

public class InMemoryBoardIdDao implements BoardIdDao {

    @Override
    public int current() {
        return 0;
    }

    @Override
    public int increment() {
        return 0;
    }
}
