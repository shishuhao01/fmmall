package com.qf.service;

import com.qf.mapper.ProductSkuMapper;
import com.qf.pojo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;

public interface ProductSkuService {
    ResultData selectById(int productId);
}
