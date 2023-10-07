package com.qf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.pojo.Product;
import com.qf.pojo.ResultData;
import org.apache.ibatis.annotations.Param;

import javax.xml.transform.Result;
import java.util.List;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 Mapper 接口
 * </p>
 *
 * @author 豪哥
 * @since 2023-10-05
 */
public interface ProductMapper extends BaseMapper<Product> {

}
