package com.qf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.pojo.ProductAllDetails;

import java.util.List;

public interface ProductAllDetailsMapper extends BaseMapper<ProductAllDetails> {
    List<ProductAllDetails> selectProductAllDetails();
}
