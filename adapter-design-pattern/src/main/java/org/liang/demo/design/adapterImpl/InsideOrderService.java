package org.liang.demo.design.adapterImpl;

import org.liang.demo.design.OrderAdapterService;
import org.liang.demo.design.service.OrderService;

/**
 * @author liang
 * Date 2020/11/14-17:12
 */
public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService=new OrderService();
    @Override
    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }
}
