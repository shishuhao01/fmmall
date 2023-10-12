package com.qf.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表
 * </p>
 *
 * @author 豪哥
 * @since 2023-10-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品主键id
     */
    @TableId
    private String productId;

    /**
     * 商品名称 商品名称
     */
    private String productName;

    /**
     * 分类外键id 分类id
     */
    private Integer categoryId;

    /**
     * 一级分类外键id 一级分类id，用于优化查询
     */
    private Integer rootCategoryId;

    /**
     * 销量 累计销售
     */
    private Integer soldNum;

    /**
     * 默认是1，表示正常状态, -1表示删除, 0下架 默认是1，表示正常状态, -1表示删除, 0下架
     */
    private Integer productStatus;

    /**
     * 商品内容 商品内容
     */
    private String content;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;



    @TableField(exist = false)
    private ProductImg productImg;

    @TableField(exist = false)
    private ProductSku productSku;


    @TableField(exist = false)
    private ProductComments productComments;

    @TableField(exist = false)
    private ProductParams productParams;


}
