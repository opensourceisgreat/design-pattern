package org.liang.demo.design;

import cn.hutool.json.JSONUtil;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

/**
 * @author liang
 * Date 2020/11/14-16:36
 */
public class MQAdapter {
    public static RebateInfo filter(String strJson, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSONUtil.parseObj(strJson), link);
    }

    public static RebateInfo filter(Map<String, Object> obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        RebateInfo rebateInfo = new RebateInfo();
        for (String key : link.keySet()) {

            Object val = obj.get(link.get(key));
            if (val instanceof Long) {

                RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), LocalDateTime.class).invoke(rebateInfo, LocalDateTime.ofInstant(Instant.ofEpochMilli((Long) val), ZoneOffset.ofHours(8)));
            } else {
                RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class).invoke(rebateInfo, val.toString());

            }
        }
        return rebateInfo;
    }
}
