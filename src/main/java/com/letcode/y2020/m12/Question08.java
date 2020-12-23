package com.letcode.y2020.m12;

import java.util.Arrays;

/**
 * @Author xiongtian
 * @Date 2020/12/22 9:51
 * @Version 1.0
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 */

public class Question08 {

    public static void main(String[] args) {
        String a="a good   example";
        Question08 question08 = new Question08();
        System.out.println(question08.reverseWords(a));
    }

    public String reverseWords(String s) {
        if (null == s || s.length() <= 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        String[] sArrs = s.split(" ");
        for (int i = sArrs.length - 1; i >= 0; i--) {
            if ("".equals(sArrs[i])) {
                continue;
            }
            res.append(sArrs[i]+" ");
        }

        return res==null ? "" : res.toString().trim();
    }
}
