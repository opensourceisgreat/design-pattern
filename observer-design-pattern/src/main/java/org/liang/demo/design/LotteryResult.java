package org.liang.demo.design;

import java.time.LocalDateTime;

/**
 * @author liang
 * Date 2020/12/2-19:44
 */
public class LotteryResult {
    private String uId;    // 用户ID
    private String msg;    // 摇号信息
    private LocalDateTime dateTime; // 业务时间

    public LotteryResult(String uId, String msg, LocalDateTime dateTime) {
        this.uId = uId;
        this.msg = msg;
        this.dateTime = dateTime;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
