package org.liang.demo.design;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author liang
 * Date 2020/11/14-16:35
 */
public class RebateInfo {
    private String userId;  // 用户ID
    private String bizId;   // 业务ID
    private LocalDateTime bizTime;   // 业务时间
    private String desc;    // 业务描述

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public LocalDateTime getBizTime() {
        return bizTime;
    }

    public void setBizTime(LocalDateTime bizTime) {
        this.bizTime = bizTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
