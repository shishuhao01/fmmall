package com.qf.service;

import com.qf.pojo.Category;
import com.qf.pojo.ResultData;

import java.util.List;

public interface CategoryService {
    ResultData selectAllCategories();
    ResultData selectSecondaryCategories (int parent_id);


}
