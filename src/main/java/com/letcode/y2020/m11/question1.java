package com.letcode.y2020.m11;

import java.util.Arrays;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/6 9:52
 * 难度：简单
 * 题目：
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组。
 */
public class question1 {
    public static void main(String[] args) {

        int[] arrs = {1,5,8,9,66,22,77};
        System.out.println(Arrays.toString(sortByBite(arrs)));
    }

    public static int[] sortByBite(int[] arrs) {

        Integer[] nums = new Integer[arrs.length];
        for (int i = 0; i < arrs.length; i++) {
            nums[i] = arrs[i];
        }
        Arrays.sort(nums, (e1, e2) -> {

            int bitCount1 = Integer.bitCount(e1);
            int bitCount2 = Integer.bitCount(e2);
            // 相同按原数，不同按位数
            return bitCount1 == bitCount2 ? e1 - e2 : bitCount1 - bitCount2;

        });
        for (int i = 0; i < nums.length; i++) {
            arrs[i] = nums[i];
        }
        return arrs;
    }

}
