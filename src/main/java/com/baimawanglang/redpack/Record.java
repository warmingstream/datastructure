package com.baimawanglang.redpack;

import java.util.Date;

public class Record {

    /** 主键 **/
    private Long id;

    /** 唯一标识 **/
    private String uuid;

    /** 用户ID **/
    private String userId;

    /** 金额 **/
    private int amount;

    /** 创建日期 **/
    private Date createDate;

    public Record() {
    }

    public Record(String uuid, String userId, int amount, Date createDate) {
        this.uuid = uuid;
        this.userId = userId;
        this.amount = amount;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
