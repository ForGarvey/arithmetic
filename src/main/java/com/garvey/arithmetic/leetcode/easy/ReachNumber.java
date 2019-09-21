package com.garvey.arithmetic.leetcode.easy;

/**
 * @Description 到达终点数字
 *  1+2+3+...+k = target，则k为答案。如果k>target，但是差值为偶数，比如k-target=4，那么第二步往左右即可，答案也是4。
 * @Author Garvey
 * @Date 2019-09-21 21:30
 */
public class ReachNumber {

    /**
     * 从0出发，每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
     * @param target    终点（target是在[-10^9, 10^9]范围中的非零整数。）
     * @return          到达终点需要的最小移动次数
     */
    public int reachNumber(int target) {
        int stepCount = 0;
        int sum = 0;
        int absTarget = Math.abs(target);

        while (sum < absTarget || (sum - absTarget) % 2 != 0) {
            stepCount++;
            sum += stepCount;
        }

        return stepCount;
    }

    public static void main(String[] args) {
        ReachNumber reachNumber = new ReachNumber();
        System.out.println(reachNumber.reachNumber(4));
        System.out.println(reachNumber.reachNumber(3));
        System.out.println(reachNumber.reachNumber(2));
    }

}
