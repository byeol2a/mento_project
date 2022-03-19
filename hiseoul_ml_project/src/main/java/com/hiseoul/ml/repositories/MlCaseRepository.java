package com.hiseoul.ml.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiseoul.ml.model.MlCase;

@Repository
public interface MlCaseRepository extends JpaRepository<MlCase, String> {
	public List<MlCase> findAllByOrderByMlCaseUuidDesc();
	public List<MlCase> findByMlCaseUuidOrMlCaseBizModelUuidOrMlCaseCctvUuidOrMlCaseRegionUuid(String mlCaseUuid,
			String mlCaseBizModelUuid,
			String mlCaseCctvUuid, 
			String mlCaseRegionUuid);
}