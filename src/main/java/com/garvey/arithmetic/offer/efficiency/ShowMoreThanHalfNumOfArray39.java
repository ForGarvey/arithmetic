package com.garvey.arithmetic.offer.efficiency;

/**
 * @Description 39
 *  数组中出现次数超过一半的数字：
 *      数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *      1.例如，输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一般，因此输出2。
 *      2.数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现次数的和还要多。
 *      因此，我们可以考虑在遍历数组的时候保存两个值：一个是数组中的一个数字，另一个是次数。
 *      3.当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1；
 *      如果下一个数字和我们之前保存的数字不同，则次数减1。如果次数为零，那么我们需要保存下一个数字，并把次数设为1.
 *      4.由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设为1时对应的数字。
 * @Author Garvey
 * @Date 2019/7/23 16:04
 */
public class ShowMoreThanHalfNumOfArray39 {

    public int moreThanHalfNum(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int result = array[0];
        int times = 1;

        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (result == array[i]) {
                times++;
            } else {
                times--;
            }
        }

        // 判断数字出现次数是否超过数组大小一半（判断输入是否有效）
        if (!checkMoreThanHalf(array, result)) {
            return 0;
        }

        return result;
    }

    /**
     * 判断数字出现次数是否超过数组大小一半
     * @param array
     * @param number
     * @return
     */
    private boolean checkMoreThanHalf(int[] array, int number) {
        if (array == null || array.length <= 0) {
            return false;
        }

        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                times++;
            }
        }

        boolean isMoreThanHalf = true;
        if (times * 2 <= array.length) {
            isMoreThanHalf = false;
        }

        return isMoreThanHalf;
    }
}
