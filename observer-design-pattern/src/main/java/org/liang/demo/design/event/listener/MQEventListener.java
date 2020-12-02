package org.liang.demo.design.event.listener;

import cn.hutool.log.StaticLog;
import org.liang.demo.design.LotteryResult;

/**
 * @author liang
 * Date 2020/12/2-19:52
 */
public class MQEventListener implements EventListener{


    @Override
    public void doEvent(LotteryResult result) {
        StaticLog.info("记录用户 {} 摇号结果(MQ)：{}", result.getuId(), result.getMsg());
    }
}
