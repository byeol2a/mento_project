package com.hiseoul.ml.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hiseoul.ml.model.MemberRe;

@Repository
public interface MemberReRepository extends CrudRepository<MemberRe, Integer> {
	public List<MemberRe> findAllByOrderByNoDesc();
	public List<MemberRe> findById(@Param("id") String id);
}