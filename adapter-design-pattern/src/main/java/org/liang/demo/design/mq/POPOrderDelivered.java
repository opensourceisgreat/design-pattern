package org.liang.demo.design.mq;

import cn.hutool.json.JSONUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author liang
 * Date 2020/11/14-15:
 * 第三方订单
 */
public class POPOrderDelivered {

    private String uId;     // 用户ID
    private String orderId; // 订单号
    private LocalDateTime orderTime; // 下单时间
    private LocalDateTime sku;       // 商品
    private LocalDateTime skuName;   // 商品名称
    private BigDecimal decimal; // 金额

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public LocalDateTime getSku() {
        return sku;
    }

    public void setSku(LocalDateTime sku) {
        this.sku = sku;
    }

    public LocalDateTime getSkuName() {
        return skuName;
    }

    public void setSkuName(LocalDateTime skuName) {
        this.skuName = skuName;
    }

    public BigDecimal getDecimal() {
        return decimal;
    }

    public void setDecimal(BigDecimal decimal) {
        this.decimal = decimal;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
