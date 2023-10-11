package com.qf.controller;

import com.qf.mapper.ProductSkuMapper;
import com.qf.pojo.ResultData;
import com.qf.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductUserController {
    @Autowired
    private ProductService productService;


    @GetMapping("/details")
    public ResultData selectHomePageByCategoryId(@RequestParam(name = "categoryId" ,defaultValue = "46"
    ) int categoryId,@RequestParam(name = "pageNum",defaultValue = "1") int pageNum,@RequestParam(name = "pageSize",defaultValue = "5") int pageSize) {
        return productService.selectProductHomePage(categoryId,pageNum,pageSize);
    }
}
