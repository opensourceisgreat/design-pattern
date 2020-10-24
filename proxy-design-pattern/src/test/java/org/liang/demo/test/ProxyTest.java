package org.liang.demo.test;

import cn.hutool.log.StaticLog;
import org.junit.Test;
import org.liang.demo.design.IUserDao;
import org.liang.demo.design.agent.RegisterBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liang
 * Date 2020/10/23-10:28
 */
public class ProxyTest {

    @Test
    public void testIUserDao(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IUserDao userDao = context.getBean("userDao", IUserDao.class);
        String s = userDao.queryUserInfo("123456");
        StaticLog.info("测试结果:{}",s);
    }
}
