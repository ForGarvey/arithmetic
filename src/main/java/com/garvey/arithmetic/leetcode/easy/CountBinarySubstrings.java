package com.garvey.arithmetic.leetcode.easy;

import java.util.Objects;

/**
 * @Description 计数二进制子串
 * @Author Garvey
 * @Date 2019-10-02 09:01
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }

        int zeroCount = 0;
        int oneCount = 0;
        int count = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            boolean isZero = chars[i] == '0';

            if (isZero) {
                if (i > 0 && chars[i] != chars[i - 1] && zeroCount != 0) {
                    zeroCount = 0;
                }
                zeroCount++;
            } else {
                if (i > 0 && chars[i] != chars[i - 1] && oneCount != 0) {
                    oneCount = 0;
                }
                oneCount++;
            }

            if (zeroCount != 0 && oneCount != 0) {
                if (isZero) {
                    count++;
                    if (zeroCount == oneCount) {
                        oneCount = 0;
                    }
                } else {
                    count++;
                    if (zeroCount == oneCount) {
                        zeroCount = 0;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();
        System.out.println(countBinarySubstrings.countBinarySubstrings("00110011"));
        System.out.println(countBinarySubstrings.countBinarySubstrings("10101"));
        System.out.println(countBinarySubstrings.countBinarySubstrings("00110"));
        System.out.println(countBinarySubstrings.countBinarySubstrings("0010"));

    }
}
