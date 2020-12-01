package org.liang.demo.design.impl;

import org.liang.demo.design.AuthInfo;
import org.liang.demo.design.AuthLink;
import org.liang.demo.design.AuthService;

import java.time.LocalDateTime;

/**
 * @author liang
 * Date 2020/12/1-21:11
 *
 * 一级负责人
 */
public class Level1AuthLink extends AuthLink {


    public Level1AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, LocalDateTime authDate) {

        LocalDateTime localDateTime = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == localDateTime) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待一级审批负责人 ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：一级审批完成负责人", " 时间：", f.format(localDateTime), " 审批人：", levelUserName);
        }
        return next.doAuth(uId, orderId, authDate);
    }
}
