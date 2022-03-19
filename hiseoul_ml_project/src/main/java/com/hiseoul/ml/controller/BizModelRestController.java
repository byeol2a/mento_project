package com.hiseoul.ml.controller;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hiseoul.ml.model.BizModel;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.BizModelRepository;
import com.hiseoul.ml.service.BizModelService;

@RestController
@RequestMapping(value="restapi/bizmodel")
public class BizModelRestController{
	private static final org.apache.logging.log4j.Logger
	logger = LogManager.getLogger(BizModelRestController.class);
		@Autowired
		BizModelRepository repository;
		
		@Autowired
		BizModelService bizmodelService;
		
		@GetMapping
		public Result retrieveBizModelList() {
			Result result = bizmodelService.retrieveBizModelList();
			return result;
		}
		@GetMapping("/{bizModelUuid}")
		public Result retrieveBizModel(@PathVariable String bizModelUuid) {
			Result result = bizmodelService.retrieveBizModel(bizModelUuid);
		    return result;
		}
		@PostMapping
		public Result createBizModel(@ModelAttribute BizModel bizmodel) {
			Result result = bizmodelService.createBizModel(bizmodel);
			return result;
		}
		
		@PutMapping
		public Result updateBizModel(@ModelAttribute BizModel bizmodel) {
			Result result = bizmodelService.updateBizModel(bizmodel);
			return result;
		}
		
		@DeleteMapping
		public Result deleteBizModel(@RequestParam String bizModelUuid) {
			Result result = bizmodelService.deleteBizModel(bizModelUuid);
			return result;
		}
		
}