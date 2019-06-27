package com.garvey.arithmetic.offer;

import java.util.Objects;

/**
 * @Description 05
 *  替换空格：
 *      将一个字符串中的空格替换成 "%20"。
 * @Author Garvey
 * @Date 2019/4/30 11:30
 */
public class ReplaceSpace05 {

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("1 B c")));
    }

    public static String replaceSpace(StringBuffer str) {
        if (Objects.isNull(str) || str.length() <= 0) {
            return "";
        }

        int oldLastIndex = str.length() - 1;

        for (int i = 0; i < oldLastIndex; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }

        int newLastIndex = str.length() - 1;

        while (oldLastIndex >= 0 && newLastIndex > oldLastIndex) {
            if (str.charAt(oldLastIndex) == ' ') {
                str.setCharAt(newLastIndex--, '0');
                str.setCharAt(newLastIndex--, '2');
                str.setCharAt(newLastIndex--, '%');
            } else {
                str.setCharAt(newLastIndex--, str.charAt(oldLastIndex));
            }
            oldLastIndex--;
        }

        return str.toString();
    }
}
