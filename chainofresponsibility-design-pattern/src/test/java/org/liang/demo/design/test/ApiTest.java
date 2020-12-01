package org.liang.demo.design.test;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import org.junit.Test;
import org.liang.demo.design.AuthLink;
import org.liang.demo.design.AuthService;
import org.liang.demo.design.impl.Level1AuthLink;
import org.liang.demo.design.impl.Level2AuthLink;
import org.liang.demo.design.impl.Level3AuthLink;

import java.time.LocalDateTime;

/**
 * @author liang
 * Date 2020/12/1-21:25
 */
public class ApiTest {

    @Test
    public void test_AuthLink() {
        AuthLink authLink = new Level3AuthLink("1000013", "王工")
                .appendNext(new Level2AuthLink("1000012", "张经理")
                        .appendNext(new Level1AuthLink("1000011", "段总")));

        StaticLog.info("测试结果：{}", JSONUtil.toJsonStr(authLink.doAuth("小傅哥", "1000998004813441", LocalDateTime.now())));

        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        StaticLog.info("测试结果：{}", "模拟三级负责人审批，王工");
        StaticLog.info("测试结果：{}", JSONUtil.toJsonStr(authLink.doAuth("小傅哥", "1000998004813441", LocalDateTime.now())));

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        StaticLog.info("测试结果：{}", "模拟二级负责人审批，张经理");
        StaticLog.info("测试结果：{}", JSONUtil.toJsonStr(authLink.doAuth("小傅哥", "1000998004813441", LocalDateTime.now())));

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        StaticLog.info("测试结果：{}", "模拟一级负责人审批，段总");
        StaticLog.info("测试结果：{}", JSONUtil.toJsonStr(authLink.doAuth("小傅哥", "1000998004813441", LocalDateTime.now())));

    }
}
