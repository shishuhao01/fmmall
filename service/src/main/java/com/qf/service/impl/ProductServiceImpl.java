package com.qf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.mapper.ProductImgMapper;
import com.qf.mapper.ProductMapper;
import com.qf.mapper.ProductSkuMapper;
import com.qf.pojo.*;
import com.qf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;


    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Autowired
    private ProductImgMapper productImgMapper;

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


































    //用户页面后端系统 根据商品分类信息查询首页信息,分页查询  首页信息包含商品姓名(product)，商品图片(product_img),售价(product_sku)
    @Override
    public ResultData selectProductHomePage(int categoryId,int pageNum,int pageSize) {
        //当前开始从pageNum - 1 * pageSize 开始
        int pageNums = (pageNum - 1) * pageSize;
        //分页查询这个id下面的分页的数据
        List<Product> products = productMapper.selectByCategoryId(categoryId, pageNums, pageSize);
        if (products == null || products.size() == 0) {
            return new ResultData(100,"查询失败");
        }
        ArrayList<Product> Re = new ArrayList();
        QueryWrapper<Product> productQueryWrapper = new QueryWrapper<>();
        productQueryWrapper.eq("category_id",categoryId);
        //查询这个分类下面的所有数据的条数
        Integer allNums = productMapper.selectCount(productQueryWrapper);

        for(Product p :products){   //有几个商品
            //使用for循环
            QueryWrapper<ProductImg> productImgQueryWrapper = new QueryWrapper<>();
            productImgQueryWrapper.eq("product_Id",p.getProductId());
            ProductImg productImg = productImgMapper.selectOne(productImgQueryWrapper);
            //根据每一项的id查询图片信息
            p.setProductImg(productImg);


            QueryWrapper<ProductSku> productSkuQueryWrapper = new QueryWrapper<>();
            productSkuQueryWrapper.eq("product_Id",p.getProductId());
            ProductSku productSku = productSkuMapper.selectOne(productSkuQueryWrapper);
            p.setProductSku(productSku);
            //根据每一项的id查询sku信息
            Re.add(p);//将这些属性添加在product里面，但是这两个属性得加上tableFeild忽略字段名
        }
        MyPage<List<Product>> myPage = new MyPage<>();
        myPage.setPageNum(pageNum);
        myPage.setPageSize(pageSize);
        int AllPageNums = (allNums + pageSize - 1) / pageSize;
        myPage.setTotalPageSize(allNums);
        myPage.setTotalPageNum(AllPageNums);
        myPage.setData(Re);
        return new ResultData(0,"查询成功",myPage);
    }
}
