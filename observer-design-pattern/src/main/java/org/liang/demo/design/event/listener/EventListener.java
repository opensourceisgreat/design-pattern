package org.liang.demo.design.event.listener;

import org.liang.demo.design.LotteryResult;

/**
 * @author liang
 * Date 2020/12/2-19:51
 */
public interface EventListener {
    void doEvent(LotteryResult result);
}
