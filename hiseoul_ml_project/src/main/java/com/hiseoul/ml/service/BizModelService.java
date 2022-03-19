package com.hiseoul.ml.service;

import com.hiseoul.ml.model.BizModel;
import com.hiseoul.ml.model.Result;

public interface BizModelService {
	public Result createBizModel(BizModel bizmodel);
	public Result retrieveBizModelList();
	public Result retrieveBizModel(String bizModelUuid);
	public Result updateBizModel(BizModel bizmodel);
	public Result deleteBizModel(String bizModelUuid);
}