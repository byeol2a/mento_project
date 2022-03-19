package com.hiseoul.ml.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiseoul.ml.model.MenuCate;

@Repository
public interface MenuCateRepository extends JpaRepository<MenuCate, Integer> {
	public List<MenuCate> findAllByOrderByCateNoDesc();
}