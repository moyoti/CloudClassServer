package com.my.util;

import redis.clients.jedis.Jedis;

/**
 * @Author: dongqihang
 * @Date: Created in 12:18 2019/3/31
 */
public class RedisTes {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("129.204.207.18");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }
}
