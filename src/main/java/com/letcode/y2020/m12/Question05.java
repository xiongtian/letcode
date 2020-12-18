package com.letcode.y2020.m12;

import java.util.Queue;

/**
 * @Author xiongtian
 * @Date 2020/12/17 9:42
 * @Version 1.0
 * <p>
 * 泰波那契序列 Tn 定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 */

public class Question05 {

    public static void main(String[] args) {
        Question05 q = new Question05();
        System.out.println(q.tribonacci1(4));
        System.out.println(q.tribonacci1(25));

        System.out.println(q.tribonacci2(4));
        System.out.println(q.tribonacci2(25));

        System.out.println(q.tribonacci3(4));
        System.out.println(q.tribonacci3(25));
    }

    /**
     * 递归的方法超出时间限制
     *
     * @param i
     * @return
     */
    public int tribonacci1(int i) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            return 1;
        }

        return tribonacci1(i - 3) + tribonacci1(i - 2) + tribonacci1(i - 1);
    }

    /**
     * 使用非递归的方式
     * @param i
     * @return
     */
    public int tribonacci2(int i) {
        if (i < 3) {
            return i == 0 ? 0 : 1;
        }
        int temp = 0, x = 0, y = 1, z = 1;

        for (int j = 3; j <= i; j++) {
            temp = x + y + z;
            x = y;
            y = z;
            z = temp;
        }
        return z;
    }


    public int tribonacci3(int i) {
        if (i < 3) {
            return i == 0 ? 0 : 1;
        }
        int[] arrs = new int[i+1];
       return tribonacci(i,arrs);
    }

    public int tribonacci(int i, int[] arrs) {
        if (i < 3) {
            return i == 0 ? 0 : 1;
        }
        arrs[i] = arrs[i]==0?(tribonacci(i - 3,arrs) + tribonacci(i - 2,arrs) + tribonacci(i - 1,arrs)):arrs[i];

        return arrs[i];
    }

}
