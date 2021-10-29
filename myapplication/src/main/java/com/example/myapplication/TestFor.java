package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试输出
 */
public class TestFor {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            if (i > 1) {
                System.out.println("这是输出第一个");
            }
        }

        for (int i = 0; i < 3; i++)
            if (i > 1) {
                System.out.println("这是输出第二个");
            }

        for (int i = 0; i < 3; i++) {
            System.out.println("这是输出第三个");
            System.out.println("这是输出第三个");
        }
        for (int i = 0; i < 3; i++)
            System.out.println("这是输出第四个");
        System.out.println("这是输出第四个。。。。。");

    }

    public int[] exchange(int[] nums) {
        List<Integer> singleList = new ArrayList();
        List<Integer> doubleList = new ArrayList();
        List<Integer> resultList = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                singleList.add(nums[i]);
            } else {
                doubleList.add(nums[i]);
            }
        }
        resultList.addAll(singleList);
        resultList.addAll(doubleList);
        int[] res = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }
        return res;
    }

    /**
     * 调整数组中的元素  使得奇数在前半部分，偶数在后半部分
     */
    public int[] exchangeDemo(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && ((nums[j] & 1) == 0)) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    /**
     * 调整数组中的 元素   使得奇数在前半部分，偶数在后半部分
     */
    public  int  [] exchangeDemoTo(int [] nums){
        int i=0;
        int j=nums.length-1;
        int temp=0;
        while (i<j){
            while (i<j&&((nums[i]&1)==1)) i++;
            while (i<j&&((nums[j]&1)==0)) j--;
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        return nums;
    }
}
