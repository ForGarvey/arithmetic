package com.garvey.arithmetic.offer.ability;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Description 59.1
 *  队列的最大值：滑动窗口的最大值
 *      给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 *      1.例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小为3，那么一共存在6个滑动窗口，它们的最大值分别为{4,4,6,6,6,5}。
 *      2.只把有可能成为滑动窗口最大值的数值存入一个两端开口的队列。滑动窗口的最大值总是位于队列的头部。
 *      3.在队列里存入数字在数组里的下标，而不是数值。当一个数字的下标与当前处理的数字的下标之差大于或者等于滑动窗口的大小时，这个
 *      数字已经从窗口中滑出，可以从队列中删除了。
 *      4.在java中直接使用优先队列表示最大堆来实现。
 * @Author Garvey
 * @Date 2019/8/7 16:16
 */
public class MaxInWindows59 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();

        if (num == null || num.length <= 0 || size <= 0 || size > num.length) {
            return list;
        }

        // 最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < size; i++) {
            maxHeap.offer(num[i]);
        }

        list.add(maxHeap.peek());

        // 维护一个大小为size的最大堆
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            maxHeap.remove(num[i]);
            maxHeap.offer(num[j]);
            list.add(maxHeap.peek());
        }

        return list;
    }

    public static void main(String[] args) {
        MaxInWindows59 maxInWindows59 = new MaxInWindows59();
        ArrayList<Integer> list = maxInWindows59.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        list.stream().forEach(System.out::println);
    }

}
