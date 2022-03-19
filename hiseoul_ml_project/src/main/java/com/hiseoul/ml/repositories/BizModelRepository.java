package com.hiseoul.ml.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiseoul.ml.model.BizModel;

@Repository
public interface BizModelRepository extends JpaRepository<BizModel, String> {
	public List<BizModel> findAllByOrderByBizModelUuidDesc();
}