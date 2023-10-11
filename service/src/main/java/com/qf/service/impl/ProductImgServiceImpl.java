package com.qf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.mapper.ProductImgMapper;
import com.qf.pojo.ProductImg;
import com.qf.pojo.ResultData;
import com.qf.service.ProductImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImgServiceImpl implements ProductImgService {
    @Autowired
    private ProductImgMapper productImgMapper;
    @Override
    public ResultData selectByProductId(int productId) {
        QueryWrapper<ProductImg> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id",productId);
        ProductImg productImg = productImgMapper.selectOne(wrapper);
        if (productImg != null) {
            return new ResultData(0,"查询成功",productImg);
        }
        return new ResultData(100,"查询失败");
    }
}
