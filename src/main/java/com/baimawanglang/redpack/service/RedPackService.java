package com.baimawanglang.redpack.service;

import com.baimawanglang.redpack.Result;

public interface RedPackService {

    /**
     * 获取红包是否过期
     * @param uuid
     * @return
     */
    public Result isExpired(String uuid);

    /**
     * 根据红包唯一ID获取红包以及红包金额
     * @param uuid  红包唯一ID
     * @param userID  用户ID
     * @return
     */
    public Result getRedPack(String uuid, String userID);
  /**
     * 根据红包唯一ID获取红包以及红包金额
     * @param uuid  红包唯一ID
     * @param userID  用户ID
     * @return
     */
    public Result getRedPackNew(String uuid, String userID);

    /**
     * 根据红包id获取领取记录
     * @param uuid
     * @return
     */
    public Result listRecords(String uuid);
}
