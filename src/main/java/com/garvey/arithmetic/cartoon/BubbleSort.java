package com.garvey.arithmetic.cartoon;

import java.util.Arrays;

/**
 * @Description 冒泡排序
 *      平均时间复杂度：O(n²)
 *      最坏时间复杂度：O(n²)
 *      空间复杂度：O(1)
 *      是否稳定排序：稳定。即值相同的元素在排序后仍然保持着排序前的顺序。
 * @Author Garvey
 * @Date 2019/8/20 16:55
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;

        for (int i = 0; i < array.length - 1; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;

            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    // 更新为最后一次交换元素的位置
                    lastExchangeIndex = j;

                    // 因为有元素进行交换，所以不是有序的，标记变为false
                    if (isSorted) {
                        isSorted = false;
                    }
                }
            }

            // 说明没有元素交换，数组已然有序，直接跳出大循环
            if (isSorted) {
                break;
            }

            // 设置无数序列的边界为最后一次交换元素的位置。
            sortBorder = lastExchangeIndex;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,5,6,7,8};
        int[] array1 = new int[]{5,8,6,3,9,2,1,7};
        bubbleSort(array);
        bubbleSort(array1);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array1));
    }
}
