package org.liang.demo.design.test;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import org.junit.Test;
import org.liang.demo.design.LotteryResult;
import org.liang.demo.design.LotteryService;
import org.liang.demo.design.LotteryServiceImpl;

/**
 * @author liang
 * Date 2020/12/2-19:07
 */
public class ApiTest {
    @Test
    public void test_observer(){
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.draw("2765789109876");
        StaticLog.info("测试结果：{}", JSONUtil.toJsonStr(result));
    }
}
