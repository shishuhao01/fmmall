package com.qf.controller;

import com.qf.pojo.Product;
import com.qf.pojo.ResultData;
import com.qf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResultData selectAll (@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        return productService.selectByPage(pageNum,pageSize);
    }

    @GetMapping("/{productId}")
    public ResultData selectById (@PathVariable Integer productId) {
        return productService.selectOne(productId);
    }

    @PutMapping("/update")
    public ResultData update (@RequestBody Product product) {
        product.setUpdateTime(new Date());
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    public ResultData delete (@PathVariable Integer productId) {
        return productService.deleteProduct(productId);
    }



}
