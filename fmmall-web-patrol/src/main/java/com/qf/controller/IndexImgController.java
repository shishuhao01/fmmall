package com.qf.controller;

import com.qf.mapper.IndexImgMapper;
import com.qf.pojo.ResultData;
import com.qf.service.IndexImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("indexImages")
public class IndexImgController {

    @Autowired
    private IndexImgService indexImgService;

    @GetMapping()
    public ResultData selectAllIndexImg() {
        return indexImgService.selectAllImage();
    }


}
