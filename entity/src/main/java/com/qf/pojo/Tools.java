package com.qf.pojo;

import org.springframework.stereotype.Service;

@Service
public class Tools {
    //判断一个字符串是否可以转化为整数
    public boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

}
