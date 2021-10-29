package com.example.datastructlearning.data;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution implements ClickATest, com.example.datastructlearning.test.ClickATest {
    @Override
    public void show() {
        System.out.println("这是一个输出");
    }


//    public ArrayList<String> restoreIpAddress(String s ){
//
//        ArrayList<String> res=new ArrayList<>();
//        ArrayList<String> ip=new ArrayList<>();//存放中间结果
//        dfs(s,res,ip,0);
//        return res;
//    }
//    private void dfs(String s,ArrayList<String> res,){
//
//    }

    /**
     * 字符串的排列
     */

    public String[]  permutation(String  s){
        List<String> ret=new ArrayList<String>();
        char[] arr=s.toCharArray();
        Arrays.sort(arr);
        do {
            ret.add(new String(arr));
        }while (next)
            int size=ret.size();
        String [] retArr=new String[size];
        for (int i = 0; i < size; i++) {
            retArr[i]=ret.get(i);
        }
        return retArr;
    }

    public  boolean nextPermutation(char[] arr){
        int i=arr.length-2;
        while (i>=0&&arr[i]>=arr[i+1]){
            i--;
        }
    }


}
