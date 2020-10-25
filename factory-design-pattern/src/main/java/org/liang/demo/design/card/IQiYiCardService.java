package org.liang.demo.design.card;

/**
 * @author liang
 * Date 2020/10/24-15:52
 */
public class IQiYiCardService {
    public void grantToken(String bindMobileNumber,String cardId){
        System.out.println("模拟发放爱奇艺会员卡："+bindMobileNumber+","+cardId);
    }

}
