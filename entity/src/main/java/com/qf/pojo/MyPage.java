package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPage<T> {
    private Integer pageNum;
    private Integer totalPageNum;
    private Integer pageSize;
    private Integer totalPageSize;
    private T data;

    public MyPage (Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
