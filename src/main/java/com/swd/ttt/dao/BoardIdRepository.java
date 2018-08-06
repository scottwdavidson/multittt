package com.swd.ttt.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BoardIdRepository extends MongoRepository<BoardId, Integer> {

}
