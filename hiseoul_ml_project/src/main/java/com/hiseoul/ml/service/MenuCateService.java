package com.hiseoul.ml.service;

import com.hiseoul.ml.model.MenuCate;
import com.hiseoul.ml.model.Result;

public interface MenuCateService {
	public Result createMenuCate(MenuCate menucate);
	public Result retrieveMenuCateList();
	public Result retrieveMenuCate(int cateNo);
	public Result updateMenuCate(MenuCate menucate);
	public Result deleteMenuCate(int cateNo);
}