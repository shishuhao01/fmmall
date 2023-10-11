package com.qf.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.mapper.ProductAllDetailsMapper;
import com.qf.pojo.ProductAllDetails;
import com.qf.pojo.ResultData;
import com.qf.service.ProductAllDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAllDetailsServiceImpl implements ProductAllDetailsService {
    @Autowired
    private ProductAllDetailsMapper productAllDetailsMapper;

    @Override
    public ResultData selectAllProductDetails(int pageNum,int pageSize) {
        Page page = new Page(pageNum,pageSize);
        List<ProductAllDetails> productAllDetails = productAllDetailsMapper.selectProductAllDetails();
        if (productAllDetails != null && productAllDetails.size() > 0) {
            return new ResultData(0,"查询成功",productAllDetails);
        }
        return new ResultData(100,"查询失败");
    }


}
