package com.example.datastructlearning.example;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {

    ///1000 瓶药水    稀释   小白鼠  2的10次方是 1024
    int ball = 1000;//总的药水

    public double getResultNumber(int total) {
        double result = Math.pow(2, total);
        return result;
    }

    /**
     * 376324255
     * <p>
     * 376324255
     * ["京张","京张高铁","京张高铁北京北站","宣传","宣传活动","活动展台","在","今天","在今天","今天的","的","宣布","了","开通","正式开通","上","，","。"]
     * 根据字典 里的内容  拆分句子到 新的数组里
     */


    String[] target = {"京张", "京张高铁", "京张高铁北京北站", "宣传", "宣传活动", "活动展台", "在", "今天", "在今天", "今天的", "的", "宣布", "了", "开通", "正式开通", "上", "，", "。"};

    public String[] getResult(String s) {
        //返回的数组
        String[] result = new String[s.length()];
        //临时要存储的结合变量
        List<String> resultString = new ArrayList<>();
        //遍历字典
        for (int i = 0; i < target.length; i++) {
            if (s.contains(target[i])) {
                resultString.add(target[i]);
                //放进去的就先移除替换
                s.replace(target[i], "");
            } else {
                //不含有字典里的数据，并且自己剩余的还不为空的时候也要存取一下
                if (!TextUtils.isEmpty(s)) {
                    resultString.add("," + s);
                }
            }
        }
        resultString.toArray(result);
        return result;
    }

    /**
     * 股票相关的
     *    对每天 的值
     */

    public  int  getEndResult(int [] prices){
        if (prices.length==0){
            return  0;
        }
        int minNum=prices[0];
        int index=0;
        int earn=0;
        for (int i = 0; i <prices.length ; i++) {
            if (prices[i]<minNum){
                minNum=prices[i];
                index=i;
            }
            int tmp=prices[i]-minNum;
            if (tmp>earn){
                earn=tmp;
            }
        }
        return earn;
    }

    /**
     * 也可采用动态规划
     */


}
