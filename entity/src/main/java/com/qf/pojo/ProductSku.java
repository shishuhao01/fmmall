package com.qf.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计
 * </p>
 *
 * @author 豪哥
 * @since 2023-10-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * sku编号
     */
    private String skuId;

    /**
     * 商品id
     */
    private String productId;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * sku图片
     */
    private String skuImg;

    /**
     * 属性组合（格式是p1:v1;p2:v2）
     */
    private String untitled;

    /**
     * 原价
     */
    private Integer originalPrice;

    /**
     * 销售价格
     */
    private Integer sellPrice;

    /**
     * 折扣力度
     */
    private BigDecimal discounts;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * sku状态(1启用，0禁用，-1删除)
     */
    private Integer status;


}
