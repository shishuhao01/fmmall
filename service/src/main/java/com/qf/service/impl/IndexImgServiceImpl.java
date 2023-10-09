package com.qf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.mapper.IndexImgMapper;
import com.qf.pojo.IndexImg;
import com.qf.pojo.ResultData;
import com.qf.service.IndexImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexImgServiceImpl implements IndexImgService {
    @Autowired
    private IndexImgMapper indexImgMapper;

    @Override
    public ResultData selectAllImage() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("update_time");
        List<IndexImg> indexImages = indexImgMapper.selectList(wrapper);
        if (indexImages != null && indexImages.size() > 0) {
            return new ResultData(0,"查询成功",indexImages);
        }

        return new ResultData(100,"查询失败");
    }
}
