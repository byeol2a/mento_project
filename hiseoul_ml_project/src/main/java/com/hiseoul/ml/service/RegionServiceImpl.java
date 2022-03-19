package com.hiseoul.ml.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hiseoul.ml.enumpkg.ServiceResult;
import com.hiseoul.ml.model.Region;
import com.hiseoul.ml.model.ErrorResponse;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService{
	private static final org.apache.logging.log4j.Logger 
	logger = LogManager.getLogger(RegionServiceImpl.class);
	@Autowired
	RegionRepository repository;
	
	public Result updateRegion(Region region) {
		Optional<Region> search = repository.findById(region.getRegionUuid());
		Result result = new Result();
		if(search.isPresent()) {
			region = repository.save(region);
			result.setPayload(region);
		}else {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}
		return result;
	}
	public Result deleteRegion(String regionUuid) {
		Result result = new Result();
		boolean isPresent = repository.findById(regionUuid).isPresent();
		if(!isPresent) {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}else {
			repository.deleteById(regionUuid);
		}
		return result;
	}
	
	@Override
	public Result createRegion(Region region) {
		region = repository.save(region);
		Result result = new Result();
		result.setPayload(region);
		return result;
	}
	
	@Override
	public Result retrieveRegionList() {
		List<Region> list = repository.findAllByOrderByRegionUuidDesc();
		Result result = new Result();
		result.setPayload(list);
		return result;
	}
	
	@Override
	public Result retrieveRegion(String regionUuid) {
		Optional<Region> optionalRegion = repository.findById(regionUuid);
		Result result = new Result();
		if(optionalRegion.isPresent()) {
			result.setPayload(optionalRegion.get());
		}else {
			result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
		}
		return result;
	}
}