package com.qf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.pojo.Category;

import java.util.List;

/**
 * <p>
 * 商品分类 Mapper 接口
 * </p>
 *
 * @author 豪哥
 * @since 2023-10-08
 */
public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> selectAllCategory();


    //根据id查询二三级菜单
    List<Category> selectSecondaryCategory(int category_Id);


    List<Category> selectThirdCategory (int categoryId);


}
