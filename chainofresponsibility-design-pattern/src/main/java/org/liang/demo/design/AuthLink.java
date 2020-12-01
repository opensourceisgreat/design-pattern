package org.liang.demo.design;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author liang
 * Date 2020/12/1-21:09
 *
 * 审核规定；
 * 1. 601-610 三级审批 + 二级审批
 * 2. 611-620 三级审批 + 二级审批 + 一级审批
 * 3. 其他时间 三级审批
 */
public abstract class AuthLink {

    protected DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    protected String levelUserId;                           // 级别人员ID
    protected String levelUserName;                         // 级别人员姓名
    private AuthLink next;                                  // 责任链

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }


    public AuthLink next() {
        return next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, LocalDateTime authDate);
}
