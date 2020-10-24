package org.liang.demo.design.agent;



import java.lang.annotation.*;

/**
 * @author liang
 * Date 2020/10/22-20:05
 * 模拟mybatis中的@select注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {
    String value() default "";//sql语句
}
