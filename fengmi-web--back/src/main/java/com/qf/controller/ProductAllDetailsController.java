package com.qf.controller;

import com.qf.pojo.ResultData;
import com.qf.service.ProductAllDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productAllDetails")
public class ProductAllDetailsController {
    @Autowired
    private ProductAllDetailsService productAllDetailsService;

    @GetMapping()
    public ResultData selectAllProductDetails (@RequestParam (defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        return productAllDetailsService.selectAllProductDetails(pageNum,pageSize);
    }

}
