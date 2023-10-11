package com.qf.controller;

import com.qf.pojo.ProductSku;
import com.qf.pojo.ResultData;
import com.qf.service.ProductSkuService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("productSku")
public class ProductSkuController {
    @Autowired
    private ProductSkuService productSkuService;

    @GetMapping("{productId}")
    public ResultData selectByProductId (@PathVariable Integer productId) {
        return productSkuService.selectById(productId);
    }


}
