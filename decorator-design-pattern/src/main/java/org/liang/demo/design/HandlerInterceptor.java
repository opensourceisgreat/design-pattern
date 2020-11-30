package org.liang.demo.design;

/**
 * @author liang
 * Date 2020/11/30-19:02
 * 模拟springmvc的拦截器
 */
public interface HandlerInterceptor {
    boolean preHandle(String request, String response, Object handler);
}
