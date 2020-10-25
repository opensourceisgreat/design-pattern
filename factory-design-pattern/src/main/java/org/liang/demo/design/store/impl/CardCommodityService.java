package org.liang.demo.design.store.impl;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import org.liang.demo.design.card.IQiYiCardService;
import org.liang.demo.design.store.ICommodity;

import java.util.Map;

/**
 * @author liang
 * Date 2020/10/24-16:01
 */
public class CardCommodityService implements ICommodity {
    //模拟注入
    private IQiYiCardService iQiYiCardService=new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        String mobile=queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile,bizId);
        StaticLog.info("请求参数[爱奇艺兑换卡]=> uId:{} commodityId:{} bizId:{} extMap:{}",uId,commodityId,bizId, JSONUtil.toJsonStr(extMap));
        StaticLog.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }
}
