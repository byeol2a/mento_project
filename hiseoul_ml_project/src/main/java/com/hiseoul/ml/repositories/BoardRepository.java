package com.hiseoul.ml.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiseoul.ml.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
	public List<Board> findAllByOrderByBoardnoDesc();
}