package com.garvey.arithmetic.offer.efficiency;

/**
 * @Description 43
 *  1~n整数中1出现的次数：
 *      输入一个整数n，求1~n这n个整数的十进制表示中1出现的次数。
 *      1.例如，输入12，1~12这些整数中包含1的数字有1、10、11和12，1一共出现了5次。
 * @Author Garvey
 * @Date 2019/7/25 17:39
 */
public class NumberOf1Between1AndN43 {

    public int numberOf1Between1AndN(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
            System.out.println(String.format("m：%s，a：%s，b：%s，cnt：%s", m, a, b, cnt));
        }
        return cnt;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN43 numberOf1Between1AndN43 = new NumberOf1Between1AndN43();
        System.out.println(numberOf1Between1AndN43.numberOf1Between1AndN(123));
    }
}
