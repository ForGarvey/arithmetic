package com.garvey.arithmetic.offer.ability;

/**
 * @Description 53.2
 *  0~n-1中缺失的数字：
 *      一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。在范围0~n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *      1.如果不在数组中的那个数字记为m，那么所有比m小的数字的下标都与它们的值相同。
 *      2.m正好是数组中第一个数值和下标不相等的元素。因此这个问题转换成在排序数组中找出第一个值和下标不相等的元素。
 * @Author Garvey
 * @Date 2019/8/2 16:40
 */
public class GetMissingNumber53 {

    public int getMissingNumber(int[] array) {
        if (array == null || array.length <= 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;
            if (array[mid] != mid) {
                if (mid == 0 || array[mid - 1] == mid - 1) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 说明缺失的数字正好是最后一个，例：长度为4，数字都在0-4范围内，数组是{0,1,2,3}，丢失的正好是4
        if (left == array.length) {
            return left;
        }

        // 无效的输入，比如数组不是按要求排序的，或者有数字不在0~n-1范围之内
        return -1;
    }

    public static void main(String[] args) {
        GetMissingNumber53 getMissingNumber53 = new GetMissingNumber53();
        System.out.println(getMissingNumber53.getMissingNumber(new int[]{0,1,3,4}));
    }

}
