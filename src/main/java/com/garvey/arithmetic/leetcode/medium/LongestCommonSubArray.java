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

        return 1;

    }
}
