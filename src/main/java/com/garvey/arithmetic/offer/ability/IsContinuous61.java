package com.garvey.arithmetic.offer.ability;

import java.util.Arrays;

/**
 * @Description 61
 *  扑克牌中的顺子：
 *      从扑克牌中随机抽取5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
 *      明天开始！重振旗鼓。0819!加油！！！！！！！
 *      1.把5张牌看成由5个数字组成的数组。大、小王是特殊的数字，不妨把它们都定义为0。
 *      2.首先把数组排序，其次统计数组中0的个数，最后统计排序之后的数组中相邻数字之间的空缺总数。如果空缺总数小于或者等于0的个数，那么这个数字则是连续的，
 *      反之则不连续。
 *      3.如果数组中的非0数字重复出现，则该数组不是连续的。换成扑克牌的描述方式就是：如果一副牌里含有对子，则不可能是顺子。
 * @Author Garvey
 * @Date 2019-08-09 19:55
 */
public class IsContinuous61 {

    public boolean isContinuous(int[] nums) {

        if (nums.length < 5) {
            return false;
        }

        Arrays.sort(nums);

        int cnt = 0;

        for (int i : nums) {
            if (i == 0) {
                cnt++;
            }
        }

        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] != 0) {
                if (nums[i + 1] == nums[i]) {
                    return false;
                }
                cnt -= nums[i + 1] - nums[i] - 1;
            }

        }

        return cnt >= 0;
    }

    public static void main(String[] args) {
        IsContinuous61 isContinuous61 = new IsContinuous61();
        System.out.println(isContinuous61.isContinuous(new int[]{3,6,4,0,7}));
        System.out.println(isContinuous61.isContinuous(new int[]{3,2,4,0,7}));
        System.out.println(isContinuous61.isContinuous(new int[]{3,0,4,0,7}));
    }
}
