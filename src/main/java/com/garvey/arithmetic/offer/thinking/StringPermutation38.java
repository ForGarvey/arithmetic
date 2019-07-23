package com.garvey.arithmetic.offer.thinking;

import java.util.ArrayList;

/**
 * @Description 38
 *  字符串的排列：
 *      输入一个字符串，打印出该字符串中字符的所有排列。
 *      1.例如，输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 *      2.把一个字符串看做由两部分组成：
 *          ① 第一部分是它的第一个字符；
 *          ② 第二部分是后面的所有字符。
 *      3.求整个字符串的排列，可以看成两步：
 *          ① 求所有可能出现在第一个位置的字符，即把第一个字符和后面的所有字符交换。
 *          ② 固定第一个字符，求后面所有字符的排列。
 *          这时候我们仍把后面的所有字符分为两部分：后面字符的第一个字符，以及这个字符之后的所有字符。然后把第一个字符逐一和它后面的字符交换。
 *      4.典型的递归问题
 * @Author Garvey
 * @Date 2019/7/23 11:19
 */
public class StringPermutation38 {

    private ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> permutation(String str) {
        if (str == null || str.length() == 0) {
            return list;
        }

        char[] chars = str.toCharArray();
        permutation(chars, new boolean[chars.length], new StringBuilder());
        return list;
    }

    /**
     * 递归排列
     * @param chars     字符数组
     * @param hasUsed   是否已排列    boolean数组的元素默认值为false
     * @param builder   字符串
     */
    private void permutation(char[] chars, boolean[] hasUsed, StringBuilder builder) {
        if (builder.length() == chars.length) {
            list.add(builder.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            // 防止字符串有重复字母的时候，导致排列重复
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) {
                continue;
            }
            hasUsed[i] = true;
            builder.append(chars[i]);
            permutation(chars, hasUsed, builder);
            // 类似于回溯法，回到上一步后，要清除刚才添加的字符，同时改掉自己已被使用的状态为false
            builder.deleteCharAt(builder.length() - 1);
            hasUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        StringPermutation38 stringPermutation38 = new StringPermutation38();
        stringPermutation38.permutation("aab");
    }
}
