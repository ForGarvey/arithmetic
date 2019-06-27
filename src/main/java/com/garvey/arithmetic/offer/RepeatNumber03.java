package com.garvey.arithmetic.offer;

import java.util.Objects;

/**
 * @Description 03
 *  数组中重复的数字：
 *      在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 *      数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * @Author Garvey
 * @Date 2019/4/29 15:10
 */
public class RepeatNumber03 {

    public static void main(String[] args) {
        int[] duplication = new int[1];
        boolean hasRepeatNumber = duplicate(new int[]{2, 3, 1, 0, 2, 5, 3}, 7, duplication);
        if (hasRepeatNumber) {
            System.out.println(duplication[0]);
        } else {
            System.out.println("数组为空或数组长度超过length或数组存在负数或数组不存在重复数字");
        }
    }

    /**
     * 找出数组中任意一个重复的数字
     * @param numbers      数组
     * @param length       数组长度
     * @param duplication  重复的数字
     * @return true:存在重复数字  false:不存在重复数字
     */
    public static boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (Objects.isNull(numbers) || length <= 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }

                swap(numbers, i, numbers[i]);
            }
        }

        return false;
    }

    /**
     * 数组元素位置交换
     * @param numbers
     * @param i
     * @param j
     */
    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
