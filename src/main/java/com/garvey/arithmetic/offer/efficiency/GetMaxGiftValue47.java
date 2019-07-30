package com.garvey.arithmetic.offer.efficiency;

/**
 * @Description 47
 *  礼物的最大值：
 *      在一个m*n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格，
 *      直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 *      1.这是一个典型的能用动态规划解决的问题。
 * @Author Garvey
 * @Date 2019/7/30 18:49
 */
public class GetMaxGiftValue47 {

    public int getMaxGiftValue(int[][] values) {
        if (values == null || values.length <= 0 || values[0].length <= 0) {
            return 0;
        }

        int cols = values[0].length;
        int[] dp = new int[cols];

        for (int[] value : values) {
            dp[0] += value[0];

            for (int i = 1; i < cols; i++) {
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];
            }
        }

        return dp[cols - 1];
    }
}
