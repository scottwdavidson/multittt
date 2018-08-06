package com.swd.ttt.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends MongoRepository<Board, Integer> {

    List<Board> findByBoardId(int boardId);
}
