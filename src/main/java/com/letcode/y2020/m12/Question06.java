package com.letcode.y2020.m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author xiongtian
 * @Date 2020/12/18 10:10
 * @Version 1.0
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 */

public class Question06 {
    public static void main(String[] args) {
        String s = "ab";
        String t = "aba";
        Question06 q = new Question06();
        System.out.println(q.findTheDifference(s, t));
    }

    /**
     * 我的解法
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char result = ' ';
        List<String> sList = new ArrayList<String>(Arrays.asList(s.split("")));
        List<String> tList = Arrays.asList(t.split(""));

        for (int i = 0; i < tList.size(); i++) {
            if (sList.contains(tList.get(i))) {
                sList.remove(tList.get(i));
            } else {
                result = tList.get(i).toCharArray()[0];
            }
        }
        return result;
    }

    /*方法一：计数
     * 首先遍历字符串 s，对其中的每个字符都将计数值加 1；然后遍历字符串 t，对其中的每个字符都将计数值减 1。
     * 当发现某个字符计数值为负数时，说明该字符在字符串 t 中出现的次数大于在字符串 s 中出现的次数，
     * 因此该字符为被添加的字符
     */
    public char findTheDifference1(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    /*方法二：求和
    *将字符串 s 中每个字符的 ASCII 码的值求和，得到 AsA_sAs​；
    * 对字符串 t 同样的方法得到 AtA_tAt​。两者的差值 At−AsA_t-A_sAt​−As​
    * 即代表了被添加的字符。
    */
    public char findTheDifference2(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    /*如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符。
    * 类似于「136. 只出现一次的数字」，我们使用位运算的技巧解决本题。
    *
    * ' ^ '：按位异或运算符
    * 两个操作数中，如果两个相应位相同，则结果为0，否则为1
    * */
    public char findTheDifference3(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }
}
