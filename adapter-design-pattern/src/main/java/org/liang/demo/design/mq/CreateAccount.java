package org.liang.demo.design.mq;

import cn.hutool.json.JSONUtil;

import java.time.LocalDateTime;

/**
 * @author liang
 * Date 2020/11/14-15:24
 * 开户
 */
public class CreateAccount {
    private String number;      // 开户编号
    private String address;     // 开户地
    private LocalDateTime accountDate;   // 开户时间
    private String desc;        // 开户描述

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(LocalDateTime accountDate) {
        this.accountDate = accountDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
