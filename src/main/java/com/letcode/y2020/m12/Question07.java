package com.letcode.y2020.m12;

import java.net.BindException;

/**
 * @Author xiongtian
 * @Date 2020/12/21 10:04
 * @Version 1.0
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 */

public class Question07 {

    public static void main(String[] args) {
        Question07 q = new Question07();
        q.multiply(13, 12);
        System.out.println(3 & 1);
        System.out.println(q.multiply(13,12));

        System.out.println(q.multiply1(13,12));

    }

    /**
     * 首先，求得A和B的最小值和最大值;
     * 然后，可以对其中的最小值当做乘数（为什么选最小值，因为选最小值当乘数，可以算的少），
     * 将其拆分成2的幂的和，即min=a0∗20+a1∗21+...+ai∗2i+...min = a_0 * 2^0 + a_1 * 2^1 + ... + a_i * 2^i + ...min=a0​∗20+a1​∗21+...+ai​∗2i+... ，其中aia_iai​取0或者1。其实就是用二进制的视角去看待min，
     * 比如12用二进制表示就是1100，即1000+0100。举个例子，13 * 12 = 13 * (8 + 4) = 13 * 8 + 13 * 4 = (13 << 3) + (13 << 2);
     *
     * @param A
     * @param B
     * @return
     */
    public int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int ans = 0;

        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                ans += max << i;
            }
            min >>= 1;
        }

        return ans;
    }

    /**
     * 递归的写法
     * @param a
     * @param b
     * @return
     */
    public int multiply1(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return mule(max, min, 0);
    }


    private int mule(int max, int min, int i) {
        if (min == 0) {
            return 0;
        }
        int temp = 0;
        if ((min & 1) == 1) {
            temp = max << i;
        }
        return temp + mule(max, min >> 1, ++i);
    }
}
