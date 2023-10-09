package com.qf.controller;

import com.qf.pojo.ResultData;
import com.qf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.sql.ResultSetMetaData;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResultData selectAllCategories () {
        return categoryService.selectAllCategories();
    }

    @GetMapping("/categories2/{parentId}")
    public ResultData selectSecondaryCategories (@PathVariable int parentId) {
        return categoryService.selectSecondaryCategories(parentId);
    }

}
