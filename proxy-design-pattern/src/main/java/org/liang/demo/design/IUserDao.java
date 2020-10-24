package org.liang.demo.design;

import org.liang.demo.design.agent.Select;

/**
 * @author liang
 * Date 2020/10/22-20:06
 * 模拟使用mybatis时，dao层只需要写好方法名即可
 */
public interface IUserDao {

    @Select("select userName from user where id=#{uId}")
    String queryUserInfo(String uId);
}
