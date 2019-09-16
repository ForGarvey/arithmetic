package com.garvey.arithmetic.interview;

/**
 * @Description 聪明的小偷
 * @Author Garvey
 * @Date 2019-09-16 22:50
 */
public class SmartSteal {

//    public static int steal(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        // 二维数组：第一位表示当前是第几间店铺，第二位表示是否偷了当前店铺：0：代表没拿 1：代表拿了
//        int[][] dp = new int[nums.length][2];
//        dp[0][0] = 0;
//        dp[0][1] = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            dp[i][0] = dp[i - 1][1];
//            dp[i][1] = dp[i - 1][0] + nums[i];
//        }
//
//        if ((nums.length & 1) == 1) {
//            // 如果店铺数量是奇数，
//            dp[nums.length - 1][1] = Math.max(dp[nums.length - 1][1] - nums[0],
//                    dp[nums.length - 1][1] - nums[nums.length - 1]);
//        }
//
//        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
//    }

    public static int steal(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(steal(new int[]{2,3,2}));
        System.out.println(steal(new int[]{1,2,3,1}));
    }
}
