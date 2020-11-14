package org.liang.demo.design.test;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import org.junit.Test;
import org.liang.demo.design.MQAdapter;
import org.liang.demo.design.OrderAdapterService;
import org.liang.demo.design.RebateInfo;
import org.liang.demo.design.adapterImpl.InsideOrderService;
import org.liang.demo.design.adapterImpl.POPOrderAdapterServiceImpl;
import org.liang.demo.design.mq.CreateAccount;
import org.liang.demo.design.mq.OrderMq;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liang
 * Date 2020/11/14-17:14
 */
public class ApiTest {

    @Test
    public void test_MQAdapter() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        LocalDateTime localDateTime = LocalDateTime.parse("2020-11-14 19:20:16", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        CreateAccount createAccount = new CreateAccount();
        createAccount.setNumber("1000001");
        createAccount.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
        createAccount.setAccountDate(localDateTime);
        createAccount.setDesc("在校开户");
        System.out.println("mq.create_account(适配前)" + createAccount.toString());

        Map<String, String> link01 = new HashMap<String, String>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(createAccount.toString(), link01);
        System.out.println("mq.create_account(适配后)" + JSONUtil.toJsonStr(rebateInfo01));


        System.out.println("");

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(localDateTime);

        HashMap<String, String> link02 = new HashMap<String, String>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);
        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" + JSONUtil.toJsonStr(rebateInfo02));

    }

    @Test
    public void test_itfAdapter(){
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderService = new InsideOrderService();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("100001"));
    }
}
