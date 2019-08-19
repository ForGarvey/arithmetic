package com.garvey.arithmetic.offer.ability;

import com.sun.org.glassfish.external.amx.AMX;

/**
 * @Description 63
 *  股票的最大利润：
 *      假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *      1.例如，一直股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。如果我们能在价格为5的时候
 *      买入并在价格为16时卖出，则能收获最大的利润11。
 *      2.蛮力法：找出数组中所有的数对，并逐一求出它们的差值。由于长度为n的数组中存在O(N²)个数对，
 *      因此该算法的时间复杂度是O(n²)。
 *      3.换一种思路，在扫描到数组中的第i个数字时，只要我们能够记住之前的i-1个数字中的最小值，
 *      就能算出在的当前价位卖出时可能得到的最大利润。
 * @Author Garvey
 * @Date 2019/8/19 16:55
 */
public class MaxProfit63 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit63 maxProfit63 = new MaxProfit63();
        System.out.println(maxProfit63.maxProfit(new int[]{9,11,8,5,7,12,16,14}));
        System.out.println(maxProfit63.maxProfit(new int[]{11,9,8,5,7,12,16,14}));
    }
}
