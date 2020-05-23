package com.mushroom.redtravel.util;

import redis.clients.jedis.Jedis;

/**
 * Jedis的工具类
 * @author Mushroom
 * @date 2020-03-07 15:24
 */
public class JedisUtil {
    static Jedis jedis;
    public static Jedis getConnect(){
        jedis=new Jedis("localhost",6379);
        jedis.connect();
        return jedis;
    }
    public static void closeConnect(){
        jedis.disconnect();
    }
}
