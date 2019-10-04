package com.garvey.arithmetic.leetcode.medium;

import java.util.Objects;

/**
 * @Description 最长重复子数组
 * @Author Garvey
 * @Date 2019-10-04 20:01
 */
public class LongestCommonSubArray {

    public int findLength(int[] A, int[] B) {
        if (Objects.isNull(A) || A.length <= 0 || Objects.isNull(B) || B.length <= 0) {
            return 0;
        }

        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] != B[j]) {
                    dp[i + 1][j + 1] = 0;
                } else {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }

        return max;
    }
}
