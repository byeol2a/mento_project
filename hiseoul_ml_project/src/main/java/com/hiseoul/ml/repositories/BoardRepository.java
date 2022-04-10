package com.hiseoul.ml.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BoardRepository extends JpaRepository<com.hiseoul.ml.model.Board, Integer> {
//	public List<Board> findByBoardno(boardno);
}