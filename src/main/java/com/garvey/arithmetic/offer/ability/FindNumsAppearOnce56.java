package com.garvey.arithmetic.offer.ability;

/**
 * @Description 56.1
 *  数组中数字出现的次数：数组中只出现一次的两个数字
 *      一个整型数组里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度O(n)，空间复杂度O(1)。
 *      1.任何一个数字异或它自己都等于0，两个不相等的元素在位级表示上必定会有一位存在不同。如果我们从头到位依次异或数组中的每个数字，
 *      那么最终的结果刚好是那两个只出现一次的数字的异或结果。
 *      2.diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以
 *      将两个元素区分开来。
 *      3.根据该位是否为1将原数组分为两个子数组，这样可以保证两个数字分别存在于这两个子数组中，然后分别对两个数组的元素进行异或，即可
 *      得到只出现一次的两个数字。
 * @Author Garvey
 * @Date 2019-08-04 11:34
 */
public class FindNumsAppearOnce56 {

    /**
     * 获取只出现一次的两个数字：num1,num2分别为长度为1的数组,将num1[0],num2[0]设置为返回结果
     * @param array
     * @param num1
     * @param num2
     */
    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        // 数组至少要有两个数字
        if (array == null || array.length < 2) {
            return;
        }

        int diff = 0;
        for (int i : array) {
            diff ^= i;
        }

        diff &= -diff;

        for (int i : array) {
            if ((i & diff) == 0) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }
        }
    }

    public static void main(String[] args) {
        FindNumsAppearOnce56 findNumsAppearOnce56 = new FindNumsAppearOnce56();
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumsAppearOnce56.findNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5}, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);

    }
}
