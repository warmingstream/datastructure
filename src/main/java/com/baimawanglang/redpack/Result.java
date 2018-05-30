package com.baimawanglang.redpack;

import java.math.BigDecimal;
import java.util.List;

/**
 * 返回结果类
 */
public class Result {

    /** 是否调用成功 **/
    private Boolean success;

    /** 是否抢到红包 **/
    private Boolean flag;

    /** 信息 **/
    private String msg;

    /** 抢到金额 **/
    private Integer money;

    private List<Record> recordList;

    public Result() {
    }

    public Result(Boolean success, Boolean flag) {
        this.success = success;
        this.flag = flag;
    }

    public Result(Boolean success, List<Record> recordList) {
        this.success = success;
        this.recordList = recordList;
    }

    public Result(Boolean success, Boolean flag, String msg) {
        this.success = success;
        this.flag = flag;
        this.msg = msg;
    }

    public Result(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Result(Boolean success, Boolean flag, String msg, Integer money) {
        this.success = success;
        this.flag = flag;
        this.msg = msg;
        this.money = money;
    }

    /** getters & setters **/
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }
}
