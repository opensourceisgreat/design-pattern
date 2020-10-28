package org.liang.demo.design.util;

import java.util.*;

/**
 * @author liang
 * Date 2020/10/28-19:25
 */
public class TopicRandomUtil {
    /**
     * 乱序Map元素，记录对应答案key
     * @param option 题目
     * @param key    答案
     * @return Topic 乱序后 {A=c., B=d., C=a., D=b.}
     */
    public static Topic random(Map<String, String> option, String key){
        Set<String> keySet = option.keySet();
        ArrayList<String> keyList = new ArrayList<String>(keySet);
        Collections.shuffle(keyList);
        HashMap<String, String> optionNew = new HashMap<String, String>();
        int index=0;
        String newKey="";
        for (String s : keySet) {
            String randomKey=keyList.get(index++);
            if (s.equals(key)) {
                newKey=randomKey;
            }

            optionNew.put(randomKey,option.get(s));
        }

        return new Topic(optionNew,newKey);

    }

}
