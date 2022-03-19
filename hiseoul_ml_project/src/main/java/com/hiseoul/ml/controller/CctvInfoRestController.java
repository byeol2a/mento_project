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
import com.hiseoul.ml.model.CctvInfo;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.CctvInfoRepository;
import com.hiseoul.ml.service.CctvInfoService;

@RestController
@RequestMapping(value="restapi/cctvinfo")
public class CctvInfoRestController{
	private static final org.apache.logging.log4j.Logger
	logger = LogManager.getLogger(CctvInfoRestController.class);
		@Autowired
		CctvInfoRepository repository;
		
		@Autowired
		CctvInfoService cctvinfoService;
		
		@GetMapping
		public Result retrieveCctvInfoList() {
			Result result = cctvinfoService.retrieveCctvInfoList();
			return result;
		}
		@GetMapping("/{cctvUuid}")
		public Result retrieveCctvInfo(@PathVariable String cctvUuid) {
			Result result = cctvinfoService.retrieveCctvInfo(cctvUuid);
		    return result;
		}
		@PostMapping
		public Result createCctvInfo(@ModelAttribute CctvInfo cctvinfo) {
			Result result = cctvinfoService.createCctvInfo(cctvinfo);
			return result;
		}
		
		@PutMapping
		public Result updateCctvInfo(@ModelAttribute CctvInfo cctvinfo) {
			Result result = cctvinfoService.updateCctvInfo(cctvinfo);
			return result;
		}
		
		@DeleteMapping
		public Result deleteCctvInfo(@RequestParam String cctvUuid) {
			Result result = cctvinfoService.deleteCctvInfo(cctvUuid);
			return result;
		}
		
}