package com.qf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.mapper.ProductImgMapper;
import com.qf.mapper.ProductSkuMapper;
import com.qf.pojo.ProductSku;
import com.qf.pojo.ResultData;
import com.qf.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSkuServiceImpl implements ProductSkuService {
    @Autowired
    private ProductSkuMapper productSkuMapper;


    @Override
    public ResultData selectById(int productId) {
        QueryWrapper<ProductSku> productSkuQueryWrapper = new QueryWrapper<>();
        productSkuQueryWrapper.eq("product_id",productId);
        ProductSku productSku = productSkuMapper.selectOne(productSkuQueryWrapper);
        if (productSku != null) {
            return new ResultData(0,"查询成功",productSku);
        }
        return new ResultData(100,"查询失败");
    }
}
