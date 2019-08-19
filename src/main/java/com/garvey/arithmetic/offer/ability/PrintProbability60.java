package com.garvey.arithmetic.offer.ability;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 60
 *  n个骰子的点数：
 *      把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *      1.可以考虑用两个数组来存储骰子点数的每个总数出现的次数。在一轮循环中，第一个数组中的第n个数字表示骰子和为n出现的次数。
 *      在下一轮循环中，我们加上一个新的骰子，此时和为n的骰子出现的次数应该等于上一轮循环中骰子点数和为n-1、n-2、n-3、n-4、
 *      n-5与n-6的次数的总和，所以把另一个数组的第n个数字设为前一个数组对应的第n-1、n-2、n-3、n-4、n-5与n-6个数字之和。
 * @Author Garvey
 * @Date 2019-08-08 17:13
 */
public class PrintProbability60 {

    public void printProbability(int number) {
        if (number < 1) {
            return;
        }

        final int maxValue = 6;

        int[][] probabilityArr = new int[2][maxValue * number + 1];

        /*for (int i = 0; i < maxValue * number + 1; i++) {
            probabilityArr[0][i] = 0;
            probabilityArr[1][i] = 0;
        }*/

        int flag = 0;

        for (int i = 1; i <= 6; i++) {
            probabilityArr[flag][i] = 1;
        }

        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++) {
                probabilityArr[1 - flag][i] = 0;
                for (int j = 0; j <= i && j<= maxValue; j++) {
                    probabilityArr[1 - flag][i] += probabilityArr[flag][i - j];
                }
            }

            flag = 1 - flag;
        }

        double total = Math.pow(maxValue, number);

        for (int i = number; i <= maxValue * number; i++) {
            double ratio = probabilityArr[flag][i] / total;
            // System.out.println(String.format("%d:%.8f", i, ratio));
            System.out.println(String.format("%d:%e", i, ratio));
        }
    }

    public static void main(String[] args) {
        PrintProbability60 printProbability60 = new PrintProbability60();
        printProbability60.printProbability(3);
    }
}
