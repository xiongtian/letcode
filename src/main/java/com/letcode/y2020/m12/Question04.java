package com.letcode.y2020.m12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author xiongtian
 * @Date 2020/12/10 9:14
 * @Version 1.0
 * <p>
 * 将所有的数字进行组合
 */

public class Question04 {

    public static void main(String[] args) {
        Question04 test = new Question04();
        String A = "abc";
        char[] arrayA = A.toCharArray();
        test.recursionArrange(arrayA, 0, arrayA.length - 1);

        System.out.println("====我是华丽的分界线===");
        String[] array = new String[]{
                "1", "2", "3"
        };
        //test.listAll(Arrays.asList(array), " ");
    }


    /*
     * 参数arrayA:给定字符串的字符数组
     * 参数start:开始遍历字符与其后面各个字符将要进行交换的位置
     * 参数end:字符串数组的最后一位
     * 函数功能：输出字符串数字的各个字符全排列
     */
    public void recursionArrange(char[] arrayA, int start, int end) {
        if (end <= 1)
            return;
        if (start == end) {
            for (int i = 0; i < arrayA.length; i++)
                System.out.print(arrayA[i]);
            System.out.println();
        } else {
            for (int i = start; i <= end; i++) {
                swap(arrayA, i, start);
                recursionArrange(arrayA, start + 1, end);
                swap(arrayA, i, start); // 还原字符串，为一下一轮for循环做准备
            }
        }

    }

    //交换数组m位置和n位置上的值
    public void swap(char[] arrayA, int m, int n) {
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }

    public void ComposeAllNum(String src) {
        char[] chars = src.toCharArray();
        for (int i = 0; i < src.length(); i++) {
            String resu = String.valueOf(src.charAt(i));
            for (int j = 0; j < src.length(); j++) {
                if (i != j) {
                    resu = resu + String.valueOf(src.charAt(j));
                    System.out.println(resu);
                }

            }
        }
    }

    /**
     * 1
     * 12
     * 123
     * 13
     * 132
     *
     * @param candidate
     * @param prefix
     */
    public void listAll(List<String> candidate, String prefix) {
        System.out.println(prefix);
        for (int i = 0; i < candidate.size(); i++) {
            List<String> temp = new LinkedList<String>(candidate);//new LinkedList<String>(candidate)---copy candidate
            listAll(temp, prefix + temp.remove(i));
        }
    }
}
