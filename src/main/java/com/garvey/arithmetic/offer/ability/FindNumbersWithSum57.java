package com.garvey.arithmetic.offer.ability;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description 57
 *  和为s的数字：和为s的两个数字
 *      输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *      1.时间复杂度为 O(n²)：
 *          先在数组中固定一个数字，再依次判断数组中其余的n-1个数字与它的和是不是等于s。
 *      2.时间复杂度为 O(n)：
 *          由于数组已经排好序了，可以先用两个指针分别指向数组中的第一个数字和最后一个数字。如果两个数字之和大于s，那么将指向最后一个
 *          数字的指针往前移动；如果两个数字之和小于s，那么将指向第一个数字的指针往后移动。
 * @Author Garvey
 * @Date 2019/8/6 14:11
 */
public class FindNumbersWithSum57 {

    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        if (array != null && array.length >= 2) {
            int i = 0, j = array.length - 1;
            while (i < j) {
                if (array[i] + array[j] == sum) {
                    return new ArrayList<>(Arrays.asList(array[i], array[j]));
                } else if (array[i] + array[j] > sum) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        return new ArrayList<>();
    }
}
