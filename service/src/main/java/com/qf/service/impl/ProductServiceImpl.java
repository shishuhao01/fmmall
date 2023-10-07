package com.qf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.mapper.ProductMapper;
import com.qf.pojo.Product;
import com.qf.pojo.ResultData;
import com.qf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResultData selectByPage(int pageNum, int pageSize) {
        Page page = new Page(pageNum,pageSize);
        productMapper.selectPage(page,null);
        if (page.getRecords() != null && page.getRecords().size() > 0) {
            return new ResultData(0,"查询成功",page);
        }
        return new ResultData(100,"查询失败");
    }

    @Override
    public ResultData selectOne(int productId) {
        Product product = productMapper.selectById(productId);
        if (product != null) {
            return new ResultData(0,"查询成功",product);
        }
        return new ResultData(100,"查询失败");
    }

    @Override
    public ResultData updateProduct(Product product) {
        int i = productMapper.updateById(product);
        if (i > 0) {
            return new ResultData(0, "修改成功");
        }
        return new ResultData(100,"修改失败");
    }

    @Override
    public ResultData deleteProduct(int id) {
        int i = productMapper.deleteById(id);
        if (i > 0) {
            return new ResultData(0,"删除成功");
        }
        return new ResultData(100,"删除失败");
    }

    @Override
    //模糊分页查询
    public ResultData selectByName(String name,Integer pageNum, Integer pageSize) {
        Page page = new Page(pageNum,pageSize);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.like("product_name",name);
        productMapper.selectPage(page,wrapper);
        if (page.getRecords() != null && page.getRecords().size() > 0) {
            //分页模糊查询成功结果为1
            return new ResultData(0,"查询成功",page);
        }
        return new ResultData(100,"查询失败");
    }

    //根据分页查询  这里需要优化
    @Override
    public ResultData selectPageById(Integer productId) {
        Page page = new Page(1,5) ;
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id",productId);
        productMapper.selectPage(page,wrapper);
        if (page.getRecords() != null && page.getRecords().size() > 0) {
            return new ResultData(0,"查询成功",page);
        }
        return new ResultData(100,"查询失败");


    }
}
