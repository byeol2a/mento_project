package com.hiseoul.ml.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hiseoul.ml.model.MlCase;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.MlCaseRepository;
import com.hiseoul.ml.service.MlCaseService;

@RestController
@RequestMapping(value="restapi/mlcase")
public class MlCaseRestController{
	private static final org.apache.logging.log4j.Logger
	logger = LogManager.getLogger(MlCaseRestController.class);
	private static final String String = null;
		@Autowired
		MlCaseRepository repository;
		
		@Autowired
		MlCaseService mlcaseService;
		
		@GetMapping
		public Result retrieveMlCaseList() {
			Result result = mlcaseService.retrieveMlCaseList();
			return result;
		}
		@GetMapping("/{mlCaseUuid}")
		public Result retrieveMlCase(@PathVariable String mlCaseUuid) {
			Result result = mlcaseService.retrieveMlCase(mlCaseUuid);
		    return result;
		}
		@GetMapping("/find")
		public ResponseEntity<List<MlCase>> findMlCase(@RequestParam(required=false) String mlCaseUuid, @RequestParam(required=false) String mlCaseBizModelUuid, @RequestParam(required=false) String mlCaseCctvUuid, @RequestParam(required=false) String mlCaseRegionUuid) {
			return new ResponseEntity<List<MlCase>>(repository.findByMlCaseUuidOrMlCaseBizModelUuidOrMlCaseCctvUuidOrMlCaseRegionUuid(mlCaseUuid, mlCaseBizModelUuid, mlCaseCctvUuid, mlCaseRegionUuid),HttpStatus.OK);
		}
		
		@PostMapping
		public Result createMlCase(@ModelAttribute MlCase mlcase) {
			Result result = mlcaseService.createMlCase(mlcase);
			return result;
		}
		
		@PutMapping
		public Result updateMlCase(@ModelAttribute MlCase mlcase) {
			Result result = mlcaseService.updateMlCase(mlcase);
			return result;
		}
		
		@DeleteMapping
		public Result deleteMlCase(@RequestParam String mlCaseUuid) {
			Result result = mlcaseService.deleteMlCase(mlCaseUuid);
			return result;
		}
		
}