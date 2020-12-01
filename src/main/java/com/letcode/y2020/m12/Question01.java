package com.letcode.y2020.m12;

import java.util.Arrays;

/**
 * @Author xiongtian
 * @Date 2020/12/1 10:16
 * @Version 1.0
 *
 *
 * 题目
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 */

public class Question01 {
    public static void main(String[] args) {
        int[] arrs ={5,7,7,8,8,10,11};
        Question01 question01 =new Question01();
        int[] ints = question01.searchRange(arrs, 8);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums,int target){
        //找到第一个等于target的数
        int leftIdx = binarySearch(nums, target, true);
        // 找到第一个大于target的数
        int rightIdx = binarySearch(nums,target,false)-1;
        if (leftIdx<=rightIdx && rightIdx <nums.length && nums[leftIdx]== target && nums[rightIdx]==target){
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums,int target,boolean lower) {
       int left = 0, right = nums.length-1,ans=nums.length;
       while (left<=right){
           int mid = (left+right)/2;
           if (nums[mid] > target || (lower && nums[mid]>=target)){
               right = mid - 1;
               ans=mid;
           }else {
               left = mid+1;
           }
       }
        return ans;
    }

}
