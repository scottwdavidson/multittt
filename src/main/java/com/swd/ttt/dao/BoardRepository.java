package com.swd.ttt.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends MongoRepository<Board, Integer> {

    Board findByMoveNumber(int moveNumber);
}
