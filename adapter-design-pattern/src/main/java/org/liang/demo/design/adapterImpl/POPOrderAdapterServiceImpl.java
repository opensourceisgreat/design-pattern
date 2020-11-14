package org.liang.demo.design.adapterImpl;

import org.liang.demo.design.OrderAdapterService;
import org.liang.demo.design.service.POPOrderService;

/**
 * @author liang
 * Date 2020/11/14-17:13
 */
public class POPOrderAdapterServiceImpl implements OrderAdapterService {
    private POPOrderService popOrderService=new POPOrderService();
    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}
