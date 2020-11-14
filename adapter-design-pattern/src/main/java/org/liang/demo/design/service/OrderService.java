package org.liang.demo.design.service;

import cn.hutool.log.StaticLog;

/**
 * @author liang
 * Date 2020/11/14-15:24
 */
public class OrderService {
    public long queryUserOrderCount(String userId) {

        StaticLog.info("自营商家，查询用户的订单是否为首单：{}", userId);
        return 10L;
    }


}
