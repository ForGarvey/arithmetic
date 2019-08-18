package com.garvey.arithmetic.offer.ability;

import java.util.Arrays;

/**
 * @Description 61
 *  扑克牌中的顺子：
 *      从扑克牌中随机抽取5张牌，判断是不是一个顺子，即这五张牌是不是连续的。
 *      明天开始！重振旗鼓。0818!加油！！！！！！！
 * @Author Garvey
 * @Date 2019-08-09 19:55
 */
public class IsContinuous61 {

    public boolean isContinuous(int[] nums) {

        if (nums.length < 5)
            return false;

        Arrays.sort(nums);

        // 统计癞子数量
        int cnt = 0;
        for (int num : nums)
            if (num == 0)
                cnt++;

        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                return false;
            cnt -= nums[i + 1] - nums[i] - 1;
        }

        return cnt >= 0;
    }
}
