package com.hiseoul.ml.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiseoul.ml.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, String> {
	public List<Region> findAllByOrderByRegionUuidDesc();
}