package com.hiseoul.ml.service;

import com.hiseoul.ml.model.MlCase;
import com.hiseoul.ml.model.Result;

public interface MlCaseService {
	public Result createMlCase(MlCase mlcase);
	public Result retrieveMlCaseList();
	public Result retrieveMlCase(String mlCaseUuid);
	public Result updateMlCase(MlCase mlcase);
	public Result deleteMlCase(String mlCaseUuid);
}