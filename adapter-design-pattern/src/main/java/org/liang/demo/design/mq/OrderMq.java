package org.liang.demo.design.mq;

import cn.hutool.json.JSONUtil;

import java.time.LocalDateTime;

/**
 * @author liang
 * Date 2020/11/14-15:17
 * 内部订单
 */
public class OrderMq {
    private String uid;           // 用户ID
    private String sku;           // 商品
    private String orderId;       // 订单ID
    private LocalDateTime createOrderTime; // 下单时间

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getCreateOrderTime() {
        return createOrderTime;
    }

    public void setCreateOrderTime(LocalDateTime createOrderTime) {
        this.createOrderTime = createOrderTime;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
