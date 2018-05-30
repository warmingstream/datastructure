package com.baimawanglang.redpack.service;


public interface RedisUtil {


    int decrBy(String s, int i);

    Integer get(String uuid);

    void set(String uuid, String s);
}
