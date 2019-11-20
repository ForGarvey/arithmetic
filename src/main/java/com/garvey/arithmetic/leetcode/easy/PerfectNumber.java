package com.garvey.arithmetic.leetcode.easy;

/**
 * @Description 完美数
 *      对于一个正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * @Author Garvey
 * @Date 2019/11/20 18:26
 */
public class PerfectNumber {

    public static boolean checkPerfectNumber(int num) {
        int sum = 1;
        int i = 2;
        for (; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }

        if (i * i == num) {
            sum += i;
        }

        return num != 1 && sum == num;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
}
