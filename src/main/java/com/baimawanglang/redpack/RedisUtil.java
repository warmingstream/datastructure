package com.baimawanglang.redpack;


public interface RedisUtil {


    int decrBy(String s, int i);

    Integer get(String uuid);

    void set(String uuid, String s);

    String getStr(String uuid);
}
