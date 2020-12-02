package org.liang.demo.design;

import java.time.LocalDateTime;

/**
 * @author liang
 * Date 2020/12/2-20:00
 */
public class LotteryServiceImpl extends LotteryService{

    private MinibusTargetService minibusTargetService = new MinibusTargetService();
    @Override
    protected LotteryResult doDraw(String uId) {

        // 摇号
        String lottery = minibusTargetService.lottery(uId);
        // 结果
        return new LotteryResult(uId, lottery, LocalDateTime.now());
    }
}
