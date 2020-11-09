package com.letcode.y2020.m11;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/9 10:03
 * 难度：简单
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Question03 {

    public static void main(String[] args) {

        Question03 q = new Question03();
        int a = 1233455;
        q.reverse3(21);
       // System.out.println(q.reverse4(21));
        System.out.println(2/10);
        System.out.println(q.reverse(a));
    }
    public int reverse(int x) {

        int result=0;
        char[] chars = null;
        String s = String.valueOf(x);
        if (s.contains("-")){
            chars = s.substring(1).toCharArray();
            this.reverseArrays(chars);
            result =- Integer.parseInt(String.valueOf(chars));

        }else {
            chars = s.toCharArray();
            this.reverseArrays(chars);
          String a=  String.valueOf(chars);
            result =Integer.parseInt(String.valueOf(chars));

        }

        int a= 2^23;
        if (-Math.pow(2,31)>= result || Math.pow(2,31) <= result){
            return 0;
        }
        return result;
    }

    /**
     * 将数组反转
     * @param chars
     */
    public void reverseArrays(char[] chars){
        if (null!=chars && chars.length>0) {
            char temp;
            int mid=chars.length / 2;
            for (int i = 0; i < mid; i++) {
                for (int j = chars.length - 1-i; j >= chars.length - 1-i; j--) {

                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
    }
    public int reverse2(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }

    /**
     * 官方的方法
     *我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
     * @param x
     * @return
     */
    public int reverse3(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverse4(int x) {
        String xString = Integer.toString(x);
        String string = xString;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            return Integer.valueOf((new StringBuilder(string)).reverse().toString()) * flag;
        }catch (Exception e){
            return 0;
        }
    }
}
