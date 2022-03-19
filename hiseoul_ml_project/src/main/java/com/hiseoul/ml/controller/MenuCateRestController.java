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
import com.hiseoul.ml.model.MenuCate;
import com.hiseoul.ml.model.Result;
import com.hiseoul.ml.repositories.MenuCateRepository;
import com.hiseoul.ml.service.MenuCateService;

@RestController
@RequestMapping(value="restapi/menucate")
public class MenuCateRestController{
	private static final org.apache.logging.log4j.Logger
	logger = LogManager.getLogger(MenuCateRestController.class);
		@Autowired
		MenuCateRepository repository;
		
		@Autowired
		MenuCateService menucateService;
		
		@GetMapping
		public Result retrieveMenuCateList() {
			Result result = menucateService.retrieveMenuCateList();
			return result;
		}
		@GetMapping("/{cateNo}")
		public Result retrieveMenuCate(@PathVariable Integer cateNo) {
			Result result = menucateService.retrieveMenuCate(cateNo);
		    return result;
		}
		@PostMapping
		public Result createMenuCate(@ModelAttribute MenuCate menucate) {
			Result result = menucateService.createMenuCate(menucate);
			return result;
		}
		
		@PutMapping
		public Result updateMenuCate(@ModelAttribute MenuCate menucate) {
			Result result = menucateService.updateMenuCate(menucate);
			return result;
		}
		
		@DeleteMapping
		public Result deleteMenuCate(@RequestParam int cateNo) {
			Result result = menucateService.deleteMenuCate(cateNo);
			return result;
		}
		
}