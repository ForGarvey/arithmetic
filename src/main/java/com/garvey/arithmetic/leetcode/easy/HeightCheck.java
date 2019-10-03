package com.garvey.arithmetic.leetcode.easy;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Description 高度检查器
 * @Author Garvey
 * @Date 2019-10-03 16:30
 */
public class HeightCheck {

    public int heightChecker(int[] heights) {
        if (Objects.isNull(heights) || heights.length <= 0) {
            return 0;
        }

        int cnt = 0;
        int[] sortedHeights = Arrays.copyOf(heights, heights.length);

        Arrays.sort(sortedHeights);

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedHeights[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}
