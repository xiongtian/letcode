package com.letcode.y2021.m02;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/2/2 10:18
 * <p>
 * 奶牛的繁殖问题：
 * 假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。
 * 第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。
 * 每只小母牛 3 年之后成熟又可以生小母牛。
 * 给定整数 n，求 n 年后牛的数量。
 */
public class Question01 {

    public static void main(String[] args) {
        Question01 question01 = new Question01();
        System.out.println(question01.solution2(6));
    }

    public int solution1(int n) {

        int[] arrs = new int[n + 1];
        return getNum(n, arrs);
    }

    private int getNum(int n, int[] arrs) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        if (arrs[n] == 0) {
            arrs[n] = getNum(n - 3, arrs) + getNum(n - 1, arrs);
        }
        return arrs[n];
    }

    public int solution2(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }

        int[] arrs = new int[n + 1];
        arrs[0] = 0;
        arrs[1] = 1;
        arrs[2] = 2;
        arrs[3] = 4;
        for (int i = 4; i <= n; i++) {
            arrs[i] =arrs[i-1]+arrs[i-3];
        }
        return arrs[n];
    }
}
