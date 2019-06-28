package com.garvey.arithmetic.offer.basics;

/**
 * @Description 15
 *  二进制中 1 的个数
 *      输入一个整数，输出该数二进制表示中 1 的个数。
 *      1.把一个整数减去1，都是把最右边的1变成0。如果它的右边还有0，则所有的0都变成1，而它左边的所有位都保持不变
 *      2.接下来我们把一个整数和它减去1的结果做位与运算，相当于把它最右边的1变成0。
 *      3.总结起来就是：把一个整数减去1，再和原整数做位与运算，会把该整数最右边的1变成0。
 *      那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
 *          n       : 10110100
 *          n-1     : 10110011
 *          n&(n-1) : 10110000
 *      2.时间复杂度：O(M)，其中 M 表示 1 的个数。
 * @Author Garvey
 * @Date 2019/6/17 10:33
 */
public class NumberOfOne15 {

    public int numberOfOne (int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    /**
     * bitCount实现的功能是计算一个（byte,short,char,int统一按照int方法计算）int,long类型的数值在二进制下“1”的数量。
     * @param n
     * @return
     */
    public int numberOf1 (int n) {
        return Integer.bitCount(n);
    }
}
