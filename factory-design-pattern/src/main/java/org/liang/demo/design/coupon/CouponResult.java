package org.liang.demo.design.coupon;

/**
 * @author liang
 * Date 2020/10/24-15:54
 */
public class CouponResult {
    //编码
    private String code;
    //描述
    private String info;

    public CouponResult(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
