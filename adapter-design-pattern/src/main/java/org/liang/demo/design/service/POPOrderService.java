package org.liang.demo.design.service;

import cn.hutool.log.StaticLog;

/**
 * @author liang
 * Date 2020/11/14-15:26
 */
public class POPOrderService {
    public boolean isFirstOrder(String uId) {
        StaticLog.info("POP商家，查询用户的订单是否为首单：{}", uId);
        return true;
    }
}
