package com.garvey.arithmetic.cartoon.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description 快速排序：二十世纪十大算法之一
 *      平均时间复杂度：O(nlogn)
 *      最坏时间复杂度：O(n²)
 *      空间复杂度：O(logn)
 *      是否稳定排序：不稳定。即值相同的元素在排序后不能保持排序前的顺序。
 *      2019.08.27重新出发。
 * @Author Garvey
 * @Date 2019-08-21 21:44
 */
public class QuickSort {

    /**
     * 双边循环法
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSortV1(int[] array, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大于或等于endIndex时
        if (startIndex >= endIndex) {
            return;
        }

        // 得到基准元素位置
        int pivotIndex = partitionV1(array, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归排序
        quickSortV1(array, startIndex, pivotIndex - 1);
        quickSortV1(array, pivotIndex + 1, endIndex);
    }

    /**
     * 分治法（双边循环法）
     * @param array         待交换的数组
     * @param startIndex    起始下标
     * @param endIndex      结束下标
     * @return
     */
    private static int partitionV1(int[] array, int startIndex, int endIndex) {
        // 取第一个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            // 控制right指针比较并左移
            while (left < right && array[right] > pivot) {
                right--;
            }

            // 控制left指针比较并右移
            while (left < right && array[left] <= pivot) {
                left++;
            }

            // 交换left和right指针所指向的元素
            if (left < right) {
                int p = array[left];
                array[left] = array[right];
                array[right] = p;
            }
        }

        // pivot和指针重合点交换
        array[startIndex] = array[left];
        array[left] = pivot;

        return left;
    }

    /**
     * 单边循环法（和双边循环法的区别在于partition函数的实现）
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSortV2(int[] array, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大于或等于endIndex时
        if (startIndex >= endIndex) {
            return;
        }

        // 得到基准元素位置
        int pivotIndex = partitionV2(array, startIndex, endIndex);
        // 根据基准元素，分成两部分进行递归排序
        quickSortV2(array, startIndex, pivotIndex - 1);
        quickSortV2(array, pivotIndex + 1, endIndex);
    }

    /**
     * 分治法（单边循环法）
     * @param array         待交换的数组
     * @param startIndex    起始下标
     * @param endIndex      结束下标
     * @return
     */
    private static int partitionV2(int[] array, int startIndex, int endIndex) {
        // 取第一个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = array[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i] < pivot) {
                mark++;
                int p = array[mark];
                array[mark] = array[i];
                array[i] = p;
            }
        }

        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    /**
     * 非递归实现（递归调用本质上就等同于一个方法在栈中入栈与出栈。这里partition方法用单边循环法）
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSortV3(int[] array, int startIndex, int endIndex) {
        // 用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        // 整个数列的起止下标，以哈希的形式入栈
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        // 循环结束条件：栈为空时
        while (!quickSortStack.isEmpty()) {
            // 栈顶元素出栈，得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            // 得到基准元素的位置
            int pivotIndex = partitionV2(array, param.get("startIndex"), param.get("endIndex"));
            // 根据基准元素分成两部分，把每一部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }

            if (param.get("endIndex") > pivotIndex + 1) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{4,4,6,5,3,2,8,1};
        quickSortV1(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = new int[]{4,4,6,5,3,2,8,1,2,7};
        quickSortV2(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));

        int[] array3 = new int[]{4,7,6,5,3,2,8,1};
        quickSortV3(array3, 0, array3.length - 1);
        System.out.println(Arrays.toString(array3));
    }
}
