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
import com.hiseoul.ml.model.Region;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.RegionRepository;
import com.hiseoul.ml.service.RegionService;

@RestController
@RequestMapping(value="restapi/region")
public class RegionRestController{
	private static final org.apache.logging.log4j.Logger
	logger = LogManager.getLogger(RegionRestController.class);
		@Autowired
		RegionRepository repository;
		
		@Autowired
		RegionService regionService;
		
		@GetMapping
		public Result retrieveRegionList() {
			Result result = regionService.retrieveRegionList();
			return result;
		}
		@GetMapping("/{regionUuid}")
		public Result retrieveRegion(@PathVariable String regionUuid) {
			Result result = regionService.retrieveRegion(regionUuid);
		    return result;
		}
		@PostMapping
		public Result createRegion(@ModelAttribute Region region) {
			Result result = regionService.createRegion(region);
			return result;
		}
		
		@PutMapping
		public Result updateRegion(@ModelAttribute Region region) {
			Result result = regionService.updateRegion(region);
			return result;
		}
		
		@DeleteMapping
		public Result deleteRegion(@RequestParam String regionUuid) {
			Result result = regionService.deleteRegion(regionUuid);
			return result;
		}
		
}