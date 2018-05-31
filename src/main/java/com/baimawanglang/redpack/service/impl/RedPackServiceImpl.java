package com.baimawanglang.redpack.service.impl;

import com.baimawanglang.redpack.*;
import com.baimawanglang.redpack.dao.RecordMapper;
import com.baimawanglang.redpack.service.RedPackService;

import java.util.Date;
import java.util.Random;

//@Service
public class RedPackServiceImpl implements RedPackService {

    //@Autowired
    private RedisUtil redisUtil;

    //@Autowired
    private RecordMapper recordMapper;

    public Result isExpired(String uuid) {
        try {
            Integer data = redisUtil.get(uuid);
            //过期
            if (data == null) {
                return new Result(true, false);
            } else {
                return new Result(true, true);
            }
        } catch (Exception e) {
            //返回异常信息
            return new Result(false, e.getMessage());
        }
    }

    //@Transactional(noRollbackFor = Throwable.class)
    public synchronized Result getRedPack(String uuid, String userID) {
        try {
            //获取剩余红包数
            String countKey = uuid + "count";
            Integer restCount = redisUtil.get(countKey);
            if (restCount == null) {
                return new Result(true, false, "红包已过期！", null);
            } else if (restCount < 1) {
                return new Result(true, false, "红包已领完！", null);
            }

            //获取金额
            Integer restAmount = redisUtil.get(uuid);
            if (restAmount == null) {
                return new Result(true, false, "红包已过期！", null);
            }

            //计算当前红包金额
            int currentAmount;
            if (restCount != 0) {
                currentAmount = calcuRedPack(restAmount, restCount);
            } else {
                currentAmount = restAmount;
            }

            //落库记录
            recordMapper.save(new Record(uuid, userID, currentAmount, new Date()));

            //回写个数、剩余金额(使用lua脚本保证原子操作)
            redisUtil.decrBy(countKey, 1);
            redisUtil.set(uuid, String.valueOf(restAmount - currentAmount));

            return new Result(true, true, null, currentAmount);
        } catch (Exception e) {
            //返回异常信息
            return new Result(false, e.getMessage());
        }
    }

    public Result getRedPackNew(String uuid, String userID) {
        try {
            //获取订单
            String orderJson = redisUtil.getStr(uuid);

            //是否过期
            if (orderJson == null) {
                return new Result(true, false, "红包已过期！");
            }

            //是否抢光
            Order order = JsonUtil.jsonToObj(orderJson, Order.class);
            if (order.getCount() < 1 || order.getAmount() < 0.01) {
                return new Result(true, false, "红包已抢光！");
            }

            //计算当前红包金额
            int currentAmount;
            if (order.getCount() > 1) {
                currentAmount = calcuRedPack(order.getAmount(), order.getCount());
            } else {
                currentAmount = order.getAmount();
            }

            //扣减金额与红包数量
            order.setAmount(order.getAmount() - currentAmount);
            order.setCount(order.getCount() - 1);

            //开启事务

            //落库记录
            recordMapper.save(new Record(uuid, userID, currentAmount, new Date()));

            //回写个数、剩余金额(使用lua脚本保证原子操作)
            redisUtil.set(uuid, JsonUtil.toJson(order));

            //事务结束

            return new Result(true, true, null, currentAmount);
        } catch (Exception e) {
            //返回异常信息
            return new Result(false, e.getMessage());
        }
    }

    public Result listRecords(String uuid) {
      try {
          return new Result(true, recordMapper.listRecords(uuid));
      } catch (Exception e) {
          //返回异常信息
          return new Result(false, e.getMessage());
      }
    }

    private int calcuRedPack(int restAmount, int count) {
        Random random = new Random();
        return random.nextInt(restAmount / count * 2 - 1) + 1;
    }

}
