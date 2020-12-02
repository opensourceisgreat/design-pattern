package org.liang.demo.design.event.listener;

import cn.hutool.log.StaticLog;
import org.liang.demo.design.LotteryResult;

/**
 * @author liang
 * Date 2020/12/2-19:52
 */
public class MessageEventListener implements EventListener{
    @Override
    public void doEvent(LotteryResult result) {

        StaticLog.info("给用户 {} 发送短信通知(短信)：{}", result.getuId(), result.getMsg());
    }
}
