package org.liang.demo.design.test;

import org.junit.Test;
import org.liang.demo.design.Builder;

/**
 * @author liang
 * Date 2020/10/26-20:17
 */
public class ApiTest {
    @Test
    public void test_Builder(){
        Builder builder = new Builder();

        // 豪华欧式
        System.out.println(builder.levelOne(132.52D).getDetail());

        // 轻奢田园
        System.out.println(builder.levelTwo(98.25D).getDetail());

        // 现代简约
        System.out.println(builder.levelThree(85.43D).getDetail());
    }
}
