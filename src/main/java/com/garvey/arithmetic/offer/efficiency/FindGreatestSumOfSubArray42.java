package com.garvey.arithmetic.offer.efficiency;

/**
 * @Description 42
 *  连续子数组的最大和：
 *      输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 *      1.例如，输入的数组为{1,-2,3,10,-4,7,2,-5}，和最大的子数组为{3,10,-4,7,2}，因此输出为该子数组的和18。
 * @Author Garvey
 * @Date 2019/7/25 16:29
 */
public class FindGreatestSumOfSubArray42 {

    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i : array) {
            if (sum < 0) {
                sum = i;
            } else {
                sum += i;
            }

            if (sum > greatestSum) {
                greatestSum = sum;
            }
        }

        return greatestSum;
    }
}
