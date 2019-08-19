package com.garvey.arithmetic.offer.ability;

/**
 * @Description 62
 *  圆圈中最后剩下的数字(即有名的约瑟夫环问题)：
 *      0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *      1.经典的解法：用环形链表模拟圆圈。时间复杂度：O(mn)，空间复杂度：O(n)
 *      2.定义一个关于n和m的方程f(n,m)，表示每次在n个数字0,1,...,n-1中删除第m个数字最后剩下的数字。
 *      时间复杂度O(n)，空间复杂度O(1)。
 *          n = 1 -> f(n,m) = 0
 *          n > 1 -> f(n,m) = [f(n-1,m) + m] % n
 * @Author Garvey
 * @Date 2019/8/19 13:46
 */
public class LastRemaining62 {

    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return  -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }

        return last;
    }

    public static void main(String[] args) {
        LastRemaining62 lastRemaining62 = new LastRemaining62();
        System.out.println(lastRemaining62.lastRemaining(5, 3));
    }
}
