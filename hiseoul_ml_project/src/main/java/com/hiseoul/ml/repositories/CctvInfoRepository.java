package com.hiseoul.ml.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiseoul.ml.model.CctvInfo;

@Repository
public interface CctvInfoRepository extends JpaRepository<CctvInfo, String> {
	public List<CctvInfo> findAllByOrderByCctvUuidDesc();
}