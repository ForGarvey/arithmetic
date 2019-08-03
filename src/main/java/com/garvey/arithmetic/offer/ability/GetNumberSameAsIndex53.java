package com.garvey.arithmetic.offer.ability;

/**
 * @Description 53.3
 *  数组中数值和下标相等的元素：
 *      假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实现一个函数，找出数组中任意一个数值等于其下标的元素。
 *      1.例如在数组{-3，-1，1，3，5}中，数字3和它的下标相等。
 *      2.利用二分查找算法：如果数字的值和下标相同，则取该数字。如果数字的值比下标大，那么忽略该数字右边的数字，接下去从它的左边开始查找。
 *      如果数字的值比下标小，那么忽略该数字左边的数字，接下去从它的右边开始查找。
 * @Author Garvey
 * @Date 2019-08-02 22:19
 */
public class GetNumberSameAsIndex53 {

    public int getNumberSameAsIndex(int[] array) {
        if (array == null || array.length <= 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] == mid) {
                return array[mid];
            } else if (array[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        GetNumberSameAsIndex53 getNumberSameAsIndex53 = new GetNumberSameAsIndex53();
        System.out.println(getNumberSameAsIndex53.getNumberSameAsIndex(new int[]{-3, -1, 1, 3, 5}));
    }

}
