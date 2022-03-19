package com.hiseoul.ml.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hiseoul.ml.enumpkg.ServiceResult;
import com.hiseoul.ml.model.BizModel;
import com.hiseoul.ml.model.ErrorResponse;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.BizModelRepository;

@Service
public class BizModelServiceImpl implements BizModelService{
	private static final org.apache.logging.log4j.Logger 
	logger = LogManager.getLogger(BizModelServiceImpl.class);
	@Autowired
	BizModelRepository repository;
	
	public Result updateBizModel(BizModel bizmodel) {
		Optional<BizModel> search = repository.findById(bizmodel.getBizModelUuid());
		Result result = new Result();
		if(search.isPresent()) {
			bizmodel = repository.save(bizmodel);
			result.setPayload(bizmodel);
		}else {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}
		return result;
	}
	public Result deleteBizModel(String bizModelUuid) {
		Result result = new Result();
		boolean isPresent = repository.findById(bizModelUuid).isPresent();
		if(!isPresent) {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}else {
			repository.deleteById(bizModelUuid);
		}
		return result;
	}
	
	@Override
	public Result createBizModel(BizModel bizmodel) {
		bizmodel = repository.save(bizmodel);
		Result result = new Result();
		result.setPayload(bizmodel);
		return result;
	}
	
	@Override
	public Result retrieveBizModelList() {
		List<BizModel> list = repository.findAllByOrderByBizModelUuidDesc();
		Result result = new Result();
		result.setPayload(list);
		return result;
	}
	
	@Override
	public Result retrieveBizModel(String bizModelUuid) {
		Optional<BizModel> optionalBizModel = repository.findById(bizModelUuid);
		Result result = new Result();
		if(optionalBizModel.isPresent()) {
			result.setPayload(optionalBizModel.get());
		}else {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}
		return result;
	}
}