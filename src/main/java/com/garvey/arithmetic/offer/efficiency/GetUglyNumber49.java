package com.garvey.arithmetic.offer.efficiency;

/**
 * @Description 49
 *  丑数：
 *      我们把只包含因子2、3和5的数称作丑数(Ugly Number)。求按从小到大的顺序的第1500个丑数。
 *      1.例如，6、8都是丑数，但14不是，因为它包含因子7。习惯上我们把1当做第一个丑数。
 *      2.所谓一个数m是另一个数n的因子，是指n能被m整除，也就是n%m=0。根据丑数的定义，丑数只能被2、3和5整除。
 *      也就是说，如果一个数能被2整除，就连续除以2；如果能被3整除，就连续除以3；如果能被5整除，就连续除以5。
 *      如果最后得到的是1，那么这个数就是丑数；否则不是。
 *      3.根据丑数的定义，丑数应该是另一个丑数乘以2、3或者5的结果（1除外）。因此，我们可以创建一个数组，里面的
 *      数字是排好序的丑数，每个丑数都是前面的丑数乘以2、3或者5得到的。
 * @Author Garvey
 * @Date 2019/7/31 15:02
 */
public class GetUglyNumber49 {

    public int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }

        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[index];

        // 第一个丑数为1
        dp[0] = 1;

        for (int i = 1; i < index; i++) {
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));

            if (dp[i] == next2) {
                i2++;
            }
            if (dp[i] == next3) {
                i3++;
            }
            if (dp[i] == next5) {
                i5++;
            }
        }

        return dp[index - 1];
    }

    public static void main(String[] args) {
        GetUglyNumber49 getUglyNumber49 = new GetUglyNumber49();
        System.out.println(getUglyNumber49.getUglyNumber(7));
        System.out.println(getUglyNumber49.getUglyNumber(1500));
    }
}
