package com.garvey.arithmetic.leetcode.easy;

import java.util.Objects;

/**
 * @Description 转换成小写字母
 * @Author Garvey
 * @Date 2019-09-25 23:20
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder("");
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (c >= 65 && c <= 90) {
                builder.append((char) (c + 32));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ToLowerCase toLowerCase = new ToLowerCase();
        System.out.println(toLowerCase.toLowerCase("Hello"));
    }
}
