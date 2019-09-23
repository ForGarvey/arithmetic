package com.garvey.arithmetic.leetcode.easy;

/**
 * @Description 搜索插入位置
 * @Author Garvey
 * @Date 2019-09-23 21:22
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
