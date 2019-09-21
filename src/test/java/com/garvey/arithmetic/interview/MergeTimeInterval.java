package com.garvey.arithmetic.interview;

import java.util.Stack;

/**
 * @Description 合并时间区间
 * @Author Garvey
 * @Date 2019-09-16 17:39
 */
public class MergeTimeInterval {

//    public int[][] merge(int[][] intervals) {
//        if (intervals == null || intervals.length == 0
//                || intervals[0] == null || intervals[0].length < 2) {
//            return null;
//        }
//
//        int rows = intervals.length;
//        int[][] mergeIntervals = new int[rows][2];
//        for (int i = 1; i < rows; i++) {
//            if (intervals[i - 1][1] > intervals[i][0]) {
//                if (intervals[i - 1][0] < intervals[i][1]) {
//                    mergeIntervals[i - 1] = new int[]{intervals[i - 1][0], intervals[i][1]};
//                }
//
//            }
//        }
//
//    }


    int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0
                || intervals[0] == null || intervals[0].length < 2) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();

        // 当前遍历到的最大数值
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            int[] arr = intervals[i];
            if (max < arr[0]) {
                // 当前区间的开始时间比最大值大，直接将当前区间压入栈
                stack.push(arr[0]);
                stack.push(arr[1]);
            } else if (max < arr[1]) {
                // 将当前栈顶弹出（也就是当前最大值），压入当前区间结束时间
                stack.pop();
                stack.push(arr[1]);
            }
            // 判断是否修改最大值为当前区间的结束时间
            max = Math.max(max, arr[1]);
        }

        int[][] mergeIntervals = new int[stack.size() / 2][2];

        for (int i = 0; i < stack.size() / 2; i++) {
            int[] interval = new int[]{stack.get(2 * i), stack.get(2 * i + 1)};
            mergeIntervals[i] = interval;
        }

        return mergeIntervals;
    }


}
