package com.hiseoul.ml.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hiseoul.ml.enumpkg.ServiceResult;
import com.hiseoul.ml.model.MlCase;
import com.hiseoul.ml.model.ErrorResponse;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.MlCaseRepository;

@Service
public class MlCaseServiceImpl implements MlCaseService{
	private static final org.apache.logging.log4j.Logger 
	logger = LogManager.getLogger(MlCaseServiceImpl.class);
	@Autowired
	MlCaseRepository repository;
	
	public Result updateMlCase(MlCase mlcase) {
		Optional<MlCase> search = repository.findById(mlcase.getMlcaseUuid());
		Result result = new Result();
		if(search.isPresent()) {
			mlcase = repository.save(mlcase);
			result.setPayload(mlcase);
		}else {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}
		return result;
	}
	public Result deleteMlCase(String mlCaseUuid) {
		Result result = new Result();
		boolean isPresent = repository.findById(mlCaseUuid).isPresent();
		if(!isPresent) {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}else {
			repository.deleteById(mlCaseUuid);
		}
		return result;
	}
	
	@Override
	public Result createMlCase(MlCase mlcase) {
		mlcase = repository.save(mlcase);
		Result result = new Result();
		result.setPayload(mlcase);
		return result;
	}
	
	@Override
	public Result retrieveMlCaseList() {
		List<MlCase> list = repository.findAllByOrderByMlCaseUuidDesc();
		Result result = new Result();
		result.setPayload(list);
		return result;
	}
	
	@Override
	public Result retrieveMlCase(String mlCaseUuid) {
		Optional<MlCase> optionalMlCase = repository.findById(mlCaseUuid);
		Result result = new Result();
		if(optionalMlCase.isPresent()) {
			result.setPayload(optionalMlCase.get());
		}else {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}
		return result;
	}
}