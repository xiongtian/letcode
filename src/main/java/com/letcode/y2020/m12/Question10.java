package com.letcode.y2020.m12;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/12/31 15:10
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * f(n) = f(n-1) + f(n-2)
 * f(0) = 1
 * f(1) = 1
 *
 * 理解：设跳上 n 级台阶有 f(n)种跳法。在所有跳法中，青蛙的最后一步只有两种情况： 跳上 1 级或 2 级台阶。
 *
 *     当为 1级台阶： 剩 n−1个台阶，此情况共有 f(n−1)种跳法；
 *     当为 2级台阶： 剩 n−2个台阶，此情况共有 f(n−2)种跳法。

 */
public class Question10 {
    public static void main(String[] args) {

        Question10 question10 = new Question10();
        System.out.println(question10.numWays1(7));
    }

    /**
     * 非递归的方式实现
     * @param n
     * @return
     */
    public int numWays1(int n) {
        int a= 0,b=1,sum =1;
        for (int i = 0; i < n; i++) {
            sum = (a + b ) %1000000007;
            a=b;
            b=sum;
        }
        return sum;
    }

    /**
     * 递归的方式实现
     * @param n
     * @return
     */
    public int numWays2(int n) {
        int[] arrs = new int[n + 1];
        return fun(n, arrs);
    }

    public int fun(int n, int[] arrs) {
        if (n == 0 || n == 1) {
            return 1;
        }
        arrs[n] = arrs[n] == 0 ? fun(n - 1, arrs) + fun(n - 2, arrs) : arrs[n];
        return arrs[n] % 1000000007;
    }
}
