package com.garvey.arithmetic.cartoon.sort;

import java.util.Arrays;

/**
 * @Description 鸡尾酒排序
 *      鸡尾酒排序的元素比较和交换过程是双向的。排序过程就像钟摆一样，第一轮从左到右，第二轮从右到左，第三轮再从左到右......
 *      平均时间复杂度：O(n²)
 *      最坏时间复杂度：O(n²)
 *      空间复杂度：O(1)
 *      是否稳定排序：稳定。即值相同的元素在排序后仍然保持着排序前的顺序。
 * @Author Garvey
 * @Date 2019/8/20 17:26
 */
public class CocktailSort {

    public static void cocktailSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            // 奇数轮，从左向右比较和交换
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

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

            // 在偶数轮之前，将isSorted重新标记为true
            isSorted = true;

            // 偶数轮，从右向左比较和交换
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;

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
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,5,6,7,8,1};
        cocktailSort(array);
        System.out.println(Arrays.toString(array));
    }

}
