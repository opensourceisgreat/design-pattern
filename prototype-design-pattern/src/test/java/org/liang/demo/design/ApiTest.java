package org.liang.demo.design;

import org.junit.Test;

/**
 * @author liang
 * Date 2020/10/28-20:27
 */
public class ApiTest {
    @Test
    public void test_QuestionBank() throws CloneNotSupportedException {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("花花", "1000001921032"));
        System.out.println(questionBankController.createPaper("豆豆", "1000001921051"));
        System.out.println(questionBankController.createPaper("大宝", "1000001921987"));

    }
}
