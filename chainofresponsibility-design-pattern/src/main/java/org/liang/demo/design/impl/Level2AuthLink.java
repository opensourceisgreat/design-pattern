package org.liang.demo.design.impl;

import org.liang.demo.design.AuthInfo;
import org.liang.demo.design.AuthLink;
import org.liang.demo.design.AuthService;

import java.time.LocalDateTime;

/**
 * @author liang
 * Date 2020/12/1-21:15
 * 二级负责人
 */
public class Level2AuthLink extends AuthLink {
    private LocalDateTime beginDate = LocalDateTime.from(f.parse("2020-06-11 00:00:00"));
    private LocalDateTime endDate = LocalDateTime.from(f.parse("2020-06-20 23:59:59"));



    public Level2AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, LocalDateTime authDate) {
        LocalDateTime date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待二级审批负责人 ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：二级审批完成负责人", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        if (authDate.isBefore(beginDate) || authDate.isAfter(endDate)) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：二级审批完成负责人", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }
}
