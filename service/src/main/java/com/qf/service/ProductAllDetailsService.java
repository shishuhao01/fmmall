package com.qf.service;

import com.qf.pojo.ResultData;

public interface ProductAllDetailsService {
    ResultData selectAllProductDetails (int pageNum, int pageSize);
}
