package com.garvey.arithmetic.offer.efficiency;

/**
 * @Description 44
 *  数字序列中某一位的数字：
 *      数字以0123456789101112131415...的格式序列化到一个字符序列中。在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
 *      请写一个函数，求任意第n为对应的数字。
 *      1.序列的第1001位是什么？
 *          ① 序列的前10位是0~9这10个只有一位的数字。显然1001位在这10个数字之后，因此这10个数字可以直接跳过。我们再从后面紧跟着的序列中
 *          找到第991（991=1001-10）位的数字。
 *          ② 接下来180位数字是90个10~99的两位数。由于991>180，所以第991位在所有的两位数之后。我们再跳过90个两位数，继续从后面找811
 *          （811=991-180）位。
 *          ③ 接下来的2700位是900个100~999的三位数。由于811<2700，所以第811位是某个三位数中的一位。由于811=270*3+1，这意味着第811位
 *          是从100开始的第270个数字即370的中间一位，也就是7。
 * @Author Garvey
 * @Date 2019/7/26 14:13
 */
public class DigitAtIndex44 {

    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }

        // 从1位数开始
        int digits = 1;

        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits) {
                return digitAtIndex(index, digits);
            }

            index -= digits * numbers;
            digits++;
        }
    }

    /**
     * digits位的数字总共有几个
     * @param digits 位数
     * @return  数字个数
     */
    private int countOfIntegers(int digits) {
        if (digits == 1) {
            return 10;
        }

        return (int) Math.pow(10, digits - 1) * 9;
    }

    /**
     * 找出对应的那一位数字
     * @param index
     * @param digits
     * @return
     */
    private int digitAtIndex(int index, int digits) {
        int num = beginNumber(digits) + index / digits;
        // 余数越小，位数反而越大
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            num /= 10;
        }

        return num % 10;
    }

    /**
     * 获取digits位数的第一个数字
     * @param digits
     * @return
     */
    private int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }

        return (int) Math.pow(10, digits - 1);
    }

    public static void main(String[] args) {
        DigitAtIndex44 digitAtIndex44 = new DigitAtIndex44();
        System.out.println(digitAtIndex44.digitAtIndex(1001));
    }

}
