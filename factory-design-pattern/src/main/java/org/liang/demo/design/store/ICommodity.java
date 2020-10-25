package org.liang.demo.design.store;

import java.util.Map;

/**
 * @author liang
 * Date 2020/10/24-14:20
 * 发奖接口
 */
public interface ICommodity {
    /**
     * 发奖方法
     * @param uId 用户ID
     * @param commodityId 商品ID
     * @param bizId 业务ID
     * @param extMap 额外参数
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String,String> extMap);
}
