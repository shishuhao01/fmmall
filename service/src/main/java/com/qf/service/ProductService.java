package com.qf.service;

import com.qf.pojo.Product;
import com.qf.pojo.ResultData;

public interface ProductService {
       ResultData selectByPage(int pageNum, int pageSize);

       ResultData selectOne (int productId);

       ResultData updateProduct (Product product);

       ResultData deleteProduct (int id);


}
