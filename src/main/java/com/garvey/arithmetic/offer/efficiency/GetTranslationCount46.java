package com.garvey.arithmetic.offer.efficiency;

/**
 * @Description 46
 *  把数字翻译成字符串：
 *      给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成“a”，1翻译成“b”，……，11翻译成“l”，……，25翻译成“z”。一个数字可能有多个翻译。
 *      请编写实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *      1.例如，12258有5种不同的翻译，分别是“bccfi”，“bwfi”、“bczi”、“mcfi”和“mzi”。
 *      2.利用递归的思想分析问题，利用动态规划来解决问题（消除重复的子问题）。
 * @Author Garvey
 * @Date 2019/7/29 17:13
 */
public class GetTranslationCount46 {

    public int getTranslationCount(int number) {
        if (number < 0) {
            return 0;
        }

        String str = String.valueOf(number);

        int[] dp = new int[str.length() + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= str.length(); i++) {
            // 先加上自己单个翻译的次数（即最后一位之前的组成次数）
            dp[i] += dp[i - 1];

            // 如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法，所以加上最后两位之前的组成次数
            if ((str.charAt(i - 2) == '1') || (str.charAt(i - 2) == '2' && str.charAt(i - 1) <= '5')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[str.length()];
    }

    public static void main(String[] args) {
        GetTranslationCount46 getTranslationCount46 = new GetTranslationCount46();
        System.out.println(getTranslationCount46.getTranslationCount(12258));
    }

}
