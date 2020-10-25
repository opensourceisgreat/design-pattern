package org.liang.demo.design.store.impl;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import org.liang.demo.design.goods.DeliverReq;
import org.liang.demo.design.goods.GoodsService;
import org.liang.demo.design.store.ICommodity;

import java.util.Map;

/**
 * @author liang
 * Date 2020/10/24-16:08
 */
public class GoodsCommodityService implements ICommodity {
    private GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        StaticLog.info("请求参数[商品] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSONUtil.toJsonStr(extMap));
        StaticLog.info("测试结果[商品]：{}", isSuccess);

        if (!isSuccess) throw new RuntimeException("实物商品发放失败");

    }

    private String queryUserName(String uId) {
        return "小明";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }
}
