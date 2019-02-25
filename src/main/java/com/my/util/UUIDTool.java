package com.my.util;

import java.util.UUID;

/**
 * @Author: dongqihang
 * @Date: Created in 17:13 2018/11/7
 */
public class UUIDTool {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
