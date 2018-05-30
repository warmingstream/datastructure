package com.baimawanglang.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConditionTester {

    public static void main(String[] args) {
       Map<String, String> params = new ConcurrentHashMap<String, String>();
       params.put("1", "");
       params.put("2", "");
       params.put("3", "");
       params.put("4", "");
       params.put("5", "");
       params.put("5", "");
       params.put("5", "");
       params.put("5", "");
    }
}


