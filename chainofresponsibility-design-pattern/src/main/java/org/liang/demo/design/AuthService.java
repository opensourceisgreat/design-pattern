package org.liang.demo.design;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liang
 * Date 2020/12/1-20:51
 *
 * 模拟审核服务
 * 1. auth          审核流程
 * 2. queryAuthInfo 查询审核信息(时间)
 */
public class AuthService {

    private static Map<String, LocalDateTime> authMap = new ConcurrentHashMap<>();

    public static void auth(String uId, String orderId) {
        authMap.put(uId.concat(orderId), LocalDateTime.now());
    }

    public static LocalDateTime queryAuthInfo(String uId, String orderId) {
        return authMap.get(uId.concat(orderId));
    }
}
