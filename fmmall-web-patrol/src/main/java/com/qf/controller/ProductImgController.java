package com.qf.controller;

import com.qf.pojo.ResultData;
import com.qf.service.ProductImgService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("productImg")
public class ProductImgController {
    @Autowired
    private ProductImgService productImgService;

    //url传参
    @GetMapping
    public ResultData selectByProductId (@RequestParam() Integer productId) {
           return productImgService.selectByProductId(productId);
    }

}
