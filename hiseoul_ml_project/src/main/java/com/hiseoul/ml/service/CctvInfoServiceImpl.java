package com.hiseoul.ml.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hiseoul.ml.enumpkg.ServiceResult;
import com.hiseoul.ml.model.CctvInfo;
import com.hiseoul.ml.model.ErrorResponse;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.CctvInfoRepository;

@Service
public class CctvInfoServiceImpl implements CctvInfoService{
	private static final org.apache.logging.log4j.Logger 
	logger = LogManager.getLogger(CctvInfoServiceImpl.class);
	@Autowired
	CctvInfoRepository repository;
	
	public Result updateCctvInfo(CctvInfo cctvinfo) {
		Optional<CctvInfo> search = repository.findById(cctvinfo.getCctvUuid());
		Result result = new Result();
		if(search.isPresent()) {
			cctvinfo = repository.save(cctvinfo);
			result.setPayload(cctvinfo);
		}else {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}
		return result;
	}
	public Result deleteCctvInfo(String cctvUuid) {
		Result result = new Result();
		boolean isPresent = repository.findById(cctvUuid).isPresent();
		if(!isPresent) {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}else {
			repository.deleteById(cctvUuid);
		}
		return result;
	}
	
	@Override
	public Result createCctvInfo(CctvInfo cctvinfo) {
		cctvinfo = repository.save(cctvinfo);
		Result result = new Result();
		result.setPayload(cctvinfo);
		return result;
	}
	
	@Override
	public Result retrieveCctvInfoList() {
		List<CctvInfo> list = repository.findAllByOrderByCctvUuidDesc();
		Result result = new Result();
		result.setPayload(list);
		return result;
	}
	
	@Override
	public Result retrieveCctvInfo(String cctvUuid) {
		Optional<CctvInfo> optionalCctvUuid = repository.findById(cctvUuid);
		Result result = new Result();
		if(optionalCctvUuid.isPresent()) {
			result.setPayload(optionalCctvUuid.get());
		}else {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}
		return result;
	}
}