package com.garvey.arithmetic.offer;

/**
 * @Description 10.1
 *  跳台阶：
 *      一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *  变态跳台阶：
 *      一只青蛙一次可以跳上1级台阶，也可以跳上2级... 它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *  原理等同于斐波那契数列
 * @Author Garvey
 * @Date 2019/5/27 10:52
 */
public class JumpFloor10 {

    public int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int pre1 = 2, pre2 = 1;
        int fib = 0;
        for (int i = 3; i <= target; i++) {
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    public int jumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }


}
