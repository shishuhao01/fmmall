package com.qf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.mapper.CategoryMapper;
import com.qf.pojo.Category;
import com.qf.pojo.ResultData;
import com.qf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public ResultData selectAllCategories() {
        List<Category> categories = categoryMapper.selectAllCategory();

        if (categories != null && categories.size() > 0) {
            return new ResultData(0,"查询成功",categories);
        }

        return new ResultData(100,"暂无分类数据");
    }

    @Override
    public ResultData selectSecondaryCategories(int parentId) {
        List<Category> categories = categoryMapper.selectSecondaryCategory(parentId);
        if (categories != null && categories.size() > 0) {
            return new ResultData(0,"查询成功",categories);
        }
        return new ResultData(100,"暂无分类数据");
    }

    @Override
    public ResultData selectThirdCategories(int categoryId) {
        List<Category> categories = categoryMapper.selectThirdCategory(categoryId);
        if (categories != null && categories.size() > 0) {
            return new ResultData(0,"查询成功",categories);
        }
        return new ResultData(100,"暂无分类数据");
    }
}
