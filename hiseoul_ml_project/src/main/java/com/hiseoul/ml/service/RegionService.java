package com.hiseoul.ml.service;

import com.hiseoul.ml.model.Region;
import com.hiseoul.ml.model.Result;

public interface RegionService {
	public Result createRegion(Region region);
	public Result retrieveRegionList();
	public Result retrieveRegion(String regionUuid);
	public Result updateRegion(Region region);
	public Result deleteRegion(String regionUuid);
}