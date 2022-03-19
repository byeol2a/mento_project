package com.hiseoul.ml.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hiseoul.ml.enumpkg.ServiceResult;
import com.hiseoul.ml.model.MenuCate;
import com.hiseoul.ml.model.ErrorResponse;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.MenuCateRepository;

@Service
public class MenuCateServiceImpl implements MenuCateService{
	private static final org.apache.logging.log4j.Logger 
	logger = LogManager.getLogger(MenuCateServiceImpl.class);
	@Autowired
	MenuCateRepository repository;
	
	public Result updateMenuCate(MenuCate menucate) {
		Optional<MenuCate> search = repository.findById(menucate.getCateno());
		Result result = new Result();
		if(search.isPresent()) {
			menucate = repository.save(menucate);
			result.setPayload(menucate);
		}else {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}
		return result;
	}
	public Result deleteMenuCate(int cateNo) {
		Result result = new Result();
		boolean isPresent = repository.findById(cateNo).isPresent();
		if(!isPresent) {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}else {
			repository.deleteById(cateNo);
		}
		return result;
	}
	
	@Override
	public Result createMenuCate(MenuCate menucate) {
		menucate = repository.save(menucate);
		Result result = new Result();
		result.setPayload(menucate);
		return result;
	}
	
	@Override
	public Result retrieveMenuCateList() {
		List<MenuCate> list = repository.findAllByOrderByCateNoDesc();
		Result result = new Result();
		result.setPayload(list);
		return result;
	}
	
	@Override
	public Result retrieveMenuCate(int cateNo) {
		Optional<MenuCate> optionalMenuCate = repository.findById(cateNo);
		Result result = new Result();
		if(optionalMenuCate.isPresent()) {
			result.setPayload(optionalMenuCate.get());
		}else {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}
		return result;
	}
}