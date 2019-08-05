package com.garvey.arithmetic.offer.ability;

/**
 * @Description 56.2
 *  数组中唯一只出现一次的数字：
 *      在一个数组中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *      1.如果一个数字出现三次，那么它的二进制表示的每一位（0或者1）也出现三次。如果把所有出现三次的数字的二进制表示的每一位
 *      都分别加起来，那么每一位的和都能被3整除。
 *      2.把数组中所有数字的二进制表示的每一位都加起来。如果某一位的和能被3整除，那么那个只出现一次的数字二进制表示中对应的
 *      那一位是0；否则就是1。
 * @Author Garvey
 * @Date 2019/8/5 16:21
 */
public class FindNumberAppearingOnce56 {

    public int findNumberAppearingOnce(int[] numbers) throws Exception{
        if (numbers == null || numbers.length <= 0) {
            throw new Exception("Invalid input");
        }

        int[] bitSum = new int[32];
        for (int i = 0; i < numbers.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = numbers[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }

                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }

        return result;
    }

    public static void main(String[] args) {
        FindNumberAppearingOnce56 findNumberAppearingOnce56 = new FindNumberAppearingOnce56();
        try {
            System.out.println(findNumberAppearingOnce56.findNumberAppearingOnce(new int[]{1,3,5,7,1,5,3,3,1,5}));
            System.out.println(findNumberAppearingOnce56.findNumberAppearingOnce(new int[]{1,-3,0,-7,1,0,-3,-3,1,0}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
