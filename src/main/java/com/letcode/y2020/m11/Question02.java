package com.letcode.y2020.m11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/6 17:04
 *
 * 难度：简单
 *给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 */
public class Question02 {

    public static void main(String[] args) {
        int[] arrs = {0,4,3,0};
        int target=0;
        int[] ints = twoSum1(arrs, target);
        System.out.println(Arrays.toString(ints));
    }

    /**
     *解法1：
     * 暴力for循环
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {

        int [] result   = new int[2];

        for (int i = 0; i < nums.length; i++) {
                for (int j=i+1;j<nums.length;j++){
                    if (nums[i]+nums[j]==target){
                        result[0] = i;
                        result[1] = j;
                        break;
                    }
            }
        }
        return result;
    }

    /**
     * 解法2：
     * 利用hash表减少寻找 target - i 的时间
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer,Integer> hashTable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target-nums[i])){
                return new int[]{hashTable.get(target-nums[i]),i};
            }
            hashTable.put(nums[i],i);
        }
        return new int[0];
    }
}
