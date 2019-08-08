package com.garvey.arithmetic.offer.ability;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 60
 *  n个骰子的点数：
 *      把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * @Author Garvey
 * @Date 2019-08-08 17:13
 */
public class PrintProbability60 {

    public void printProbability(int number) {
        if (number < 1) {
            return;
        }


        

    }

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[2][pointNum + 1];

        for (int i = 1; i <= face; i++)
            dp[0][i] = 1;

        int flag = 1;                                     /* 旋转标记 */
        for (int i = 2; i <= n; i++, flag = 1 - flag) {
            for (int j = 0; j <= pointNum; j++)
                dp[flag][j] = 0;                          /* 旋转数组清零 */

            for (int j = i; j <= pointNum; j++)
                for (int k = 1; k <= face && k <= j; k++)
                    dp[flag][j] += dp[1 - flag][j - k];
        }

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++)
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[1 - flag][i] / totalNum));

        return ret;
    }
}
