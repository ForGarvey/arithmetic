package com.garvey.arithmetic.offer.quality;

/**
 * @Description 21
 *  调整数组顺序使奇数位于偶数前面：
 *      输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 *      并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @Author Garvey
 * @Date 2019/7/9 17:00
 */
public class ReOrderArray21 {

    /**
     * 创建一个新数组，时间复杂度O(n)，空间复杂度O(n)
     * @param array
     */
    public void reOrderArray1(int[] array) {
        // 奇数个数
        int oddCnt = 0;
        for (int x : array) {
            if (!isEven(x)) {
                oddCnt++;
            }
        }

        int[] copy = array.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1) {
                array[i++] = num;
            } else {
                array[j++] = num;
            }
        }
    }

    /**
     * 使用冒泡思想，每次都当前偶数上浮到当前最右边。时间复杂度 O(N2)，空间复杂度 O(1)，时间换空间。
     * @param array
     */
    public void reOrderArray(int[] array) {
        int N = array.length;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isEven(array[j]) && !isEven(array[j + 1])) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private boolean isEven(int x) {
        return x % 2 == 0;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
