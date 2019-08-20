package com.garvey.arithmetic.offer.example;

/**
 * @Description 67
 *  把字符串转换成整数：
 *      1.将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 *      要求不能使用字符串转换整数的库函数。
 *      2.数值为0或者字符串不是一个合法的数值则返回0。
 * @Author Garvey
 * @Date 2019/8/20 11:27
 */
public class StrToInt67 {

    /**
     * 是否为非法输入 0：不是  1：是
     */
    public int invalidStatus = 0;

    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            invalidStatus = 1;
            return 0;
        }

        boolean isNegative = str.charAt(0) == '-';
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }

            if (c < '0' || c > '9') {
                return 0;
            }

            result = result * 10 + (c - '0');
        }

        return isNegative ? -result : result;
    }


}
