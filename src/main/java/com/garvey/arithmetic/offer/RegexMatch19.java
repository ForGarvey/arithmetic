package com.garvey.arithmetic.offer;

/**
 * @Description 19
 *  正则表达式匹配:
 *      1.请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
 *      2.在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串 "aaa" 与模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配。
 *      3.应该注意到，'.' 是用来当做一个任意字符，而 '*' 是用来重复前面的字符。这两个的作用不同，不能把 '.' 的作用和 '*' 进行类比，从而把它当成重复前面字符一次。
 * @Author Garvey
 * @Date 2019/6/17 17:36
 */
public class RegexMatch19 {

    /**
     * 匹配
     * @param str       字符串的字节数组
     * @param pattern   正则的字节数组
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        int strLength = str.length;
        int patternLength = pattern.length;

        boolean[][] dp = new boolean[strLength + 1][patternLength + 1];

        dp[0][0] = true;
        for (int i = 1; i <= patternLength; i++) {
            if (pattern[i - 1] == '*') {
                // 第一位不可能是 *，所以 dp[0][i - 2] 不会报错
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= strLength; i++) {
            for (int j = 1; j <= patternLength; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        // a* 可能匹配一个a
                        dp[i][j] |= dp[i][j - 1];
                        // a* 可能匹配多个a
                        dp[i][j] |= dp[i - 1][j];
                        // a* 可能没有a
                        dp[i][j] |= dp[i][j - 2];
                    } else {
                        // a* 没有a
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[strLength][patternLength];
    }
}
