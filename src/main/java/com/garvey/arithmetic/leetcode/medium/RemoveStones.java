package com.garvey.arithmetic.leetcode.medium;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description 移除最多的同行或同列石头
 * @Author Garvey
 * @Date 2019-09-29 20:53
 */
public class RemoveStones {

    public int removeStones(int[][] stones) {
        if (Objects.isNull(stones) || stones.length <= 0
                || Objects.isNull(stones[0]) || stones[0].length < 2) {
            return 0;
        }

        // X轴
        Map<Integer, Integer> xMap = new HashMap<>();

        // Y轴
        Map<Integer, Integer> yMap = new HashMap<>();

        for (int[] stone : stones) {
            if (xMap.containsKey(stone[0])) {
                xMap.put(stone[0], xMap.get(stone[0]) + 1);
            } else {
                xMap.put(stone[0], 1);
            }

            if (yMap.containsKey(stone[1])) {
                yMap.put(stone[1], yMap.get(stone[1]) + 1);
            } else {
                yMap.put(stone[1], 1);
            }
        }

        // 本次是否有取出
        boolean hasRemove = true;

        BitSet bitSet = new BitSet(stones.length);

        // 要优先删除只有一条坐标有相交的点
        while (hasRemove && (bitSet.cardinality() < stones.length)) {
            hasRemove = false;
            int index = 0;
            int removeIndex = -1;
            int value = 0;
            while (index < stones.length) {

                if (bitSet.get(index)) {
                    index++;
                    continue;
                }

                if ((xMap.get(stones[index][0]) == 1 && yMap.get(stones[index][1]) > 1)
                        || (xMap.get(stones[index][0]) > 1 && yMap.get(stones[index][1]) == 1)) {
                    removeIndex = index;
                    hasRemove = true;
                    break;
                } else if (xMap.get(stones[index][0]) > 1 && yMap.get(stones[index][1]) > 1
                        && (value == 0 || (value > xMap.get(stones[index][0]) + yMap.get(stones[index][1])))) {
                    // 先记录下位置，不能直接break
                    value = xMap.get(stones[index][0]) + yMap.get(stones[index][1]);
                    removeIndex = index;
                    hasRemove = true;
                }
                index++;

            }
            if (hasRemove) {
                xMap.put(stones[removeIndex][0], xMap.get(stones[removeIndex][0]) - 1);
                yMap.put(stones[removeIndex][1], yMap.get(stones[removeIndex][1]) - 1);
                bitSet.set(removeIndex);
            }
        }

        return bitSet.cardinality();
    }

    public static void main(String[] args) {
        RemoveStones removeStones = new RemoveStones();
        System.out.println(removeStones.removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
        System.out.println(removeStones.removeStones(new int[][]{{0,1},{1,2},{1,3},{3,3},{2,3},{0,2}}));
    }
}
