package com.qf.pojo;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品图片
 * </p>
 *
 * @author 豪哥
 * @since 2023-10-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductImg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图片主键
     */
    private String id;

    /**
     * 商品外键id 商品外键id
     */
    private String productId;

    /**
     * 图片地址 图片地址
     */
    private String url;

    /**
     * 顺序 图片顺序，从小到大
     */
    private Integer sort;

    /**
     * 是否主图 是否主图，1：是，0：否
     */
    private Integer isMain;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;


}
