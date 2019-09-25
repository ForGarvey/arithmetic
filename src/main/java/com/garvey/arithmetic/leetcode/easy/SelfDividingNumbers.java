package com.garvey.arithmetic.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 自除数
 * @Author Garvey
 * @Date 2019-09-25 23:43
 */
public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList();

        if (left <= right) {
            for (int i = left; i <= right; i++) {
                if (selfDivision(i)) {
                    list.add(i);
                }
            }
        }

        return list;
    }

    public static boolean selfDivision(int number) {
        int quotient = number;
        while (quotient > 0) {
            int bitValue = quotient % 10;
            quotient /= 10;
            if (bitValue == 0 || (number % bitValue != 0)) {
                return false;
            }
        }
        return true;
    }
}
