package org.liang.demo.design.store.impl;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import org.liang.demo.design.coupon.CouponResult;
import org.liang.demo.design.coupon.CouponService;
import org.liang.demo.design.store.ICommodity;

import java.util.Map;

/**
 * @author liang
 * Date 2020/10/24-16:06
 */
public class CouponCommodityService implements ICommodity {
    private CouponService couponService = new CouponService();
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        StaticLog.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSONUtil.toJsonStr(extMap));
        StaticLog.info("测试结果[优惠券]：{}", JSONUtil.toJsonStr(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException("优惠券码有错误");

    }
}
