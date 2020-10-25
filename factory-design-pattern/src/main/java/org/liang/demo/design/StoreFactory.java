package org.liang.demo.design;

import org.liang.demo.design.store.ICommodity;
import org.liang.demo.design.store.impl.CardCommodityService;
import org.liang.demo.design.store.impl.CouponCommodityService;
import org.liang.demo.design.store.impl.GoodsCommodityService;

/**
 * @author liang
 * Date 2020/10/24-14:20
 */
public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
