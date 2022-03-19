package com.hiseoul.ml.service;

import com.hiseoul.ml.model.CctvInfo;
import com.hiseoul.ml.model.Result;

public interface CctvInfoService {
	public Result createCctvInfo(CctvInfo cctvinfo);
	public Result retrieveCctvInfoList();
	public Result retrieveCctvInfo(String cctvUuid);
	public Result updateCctvInfo(CctvInfo cctvinfo);
	public Result deleteCctvInfo(String cctvUuid);
}