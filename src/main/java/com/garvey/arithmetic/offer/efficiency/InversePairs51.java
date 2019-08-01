package com.garvey.arithmetic.offer.efficiency;

import java.util.Arrays;

/**
 * @Description 51
 *  数组中的逆序对：
 *      在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中逆序对的总数。
 *      1.例如，在数组{7,5,6,4}中，一共存在5个逆序对，分别是(7,6)、(7,5)、(7,4)、(6,4)和(5,4)。
 *      2.先把数组分隔成子数组，统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目。
 *      在统计逆序对的过程中，还需要对数组进行排序（把较大的数组从后往前复制到一个辅助数组，确保辅助数组中的数字是递增排序的）。
 *      3.这里的排序过程实际上就是归并排序。
 * @Author Garvey
 * @Date 2019/8/1 15:30
 */
public class InversePairs51 {

    public int inversePairs(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        
        int[] copy = Arrays.copyOf(array, array.length);

        int count = inversePairsCore(array, copy, 0, array.length - 1);

        return count;
    }

    public int inversePairsCore(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }

        int length = (end - start) / 2;

        int left = inversePairsCore(copy, array, start, start + length);
        int right = inversePairsCore(copy, array, start + length + 1, end);

        // i初始化为前半段最后一个数字的下标
        int i = start + length;

        // j初始化为后半段最后一个数字的下标
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - start - length;
                // 数值过大求余
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[indexCopy--] = array[j--];
            }
        }

        for (; i >= start; --i) {
            copy[indexCopy--] = array[i];
        }

        for (; j >= start + length + 1; --j) {
            copy[indexCopy--] = array[j];
        }

        return (left + right + count) % 1000000007;
    }

    public static void main(String[] args) {
        InversePairs51 inversePairs51 = new InversePairs51();
        System.out.println(inversePairs51.inversePairs(new int[]{7,5,6,4}));
    }
}
