package com.garvey.arithmetic.leetcode.easy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description 独一无二的出现次数
 * @Author Garvey
 * @Date 2019-09-30 16:08
 */
public class UniqueOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        if (Objects.isNull(arr) || arr.length <= 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Collection<Integer> valueList = map.values();

        return valueList.stream().distinct().count() == valueList.size();
    }

}
