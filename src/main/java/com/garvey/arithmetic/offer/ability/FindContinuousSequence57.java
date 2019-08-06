package com.garvey.arithmetic.offer.ability;

import java.util.ArrayList;

/**
 * @Description 57.2
 *  和为s的连续正数序列：
 *      输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 *      1.例如，输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以打印出3个连续序列1~5、4~6和7~8。
 *      2.用两个数small和big分别表示序列的最小值和最大值。首先把small初始化为1，big初始化为2。
 *          ① 如果从small到big的序列的和大于s，则可以从序列中去掉较小的值，也就是增大small的值。
 *          ② 如果从small到big的序列的和小于s，则可以增大big，让这个序列包含更多的数字。
 *      3.因为这个序列至少要有两个数字，我们一直增加small到(1+s)/2为止。
 * @Author Garvey
 * @Date 2019/8/6 14:48
 */
public class FindContinuousSequence57 {

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        if (sum < 3) {
            return lists;
        }

        int small = 1, big = 2, mid = (sum + 1) / 2, curSum = 3;

        while (small < mid) {
            if (curSum < sum) {
                big++;
                curSum += big;
            } else if (curSum > sum) {
                curSum -= small;
                small++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }

                lists.add(list);

                curSum -= small;
                small++;
                big++;
                curSum += big;
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        FindContinuousSequence57 findContinuousSequence57 = new FindContinuousSequence57();
        ArrayList<ArrayList<Integer>> lists = findContinuousSequence57.findContinuousSequence(15);
        for (ArrayList<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
