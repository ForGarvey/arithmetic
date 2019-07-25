package com.garvey.arithmetic.offer.efficiency;

import java.util.PriorityQueue;

/**
 * @Description 41
 *  数据流中的中位数：
 *      如何得到一个数据流中的中位数？
 *      1.如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *      2.如果从数据流中读出偶数个值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *      3.如果能够保证数据容器左边的数据都小于右边的数据，那么即使左、右两边内部的数据没有排序，也可以根据左边最大的数及右边最小的数得到中位数。
 *      4.如何快速从一个数据容器中找出最大数？用最大堆实现这个数据容器，因为位于堆顶的就是最大的数据。同样，也可以快速从最小堆中找出最小数。
 *      5.因此用一个最大堆实现左边的数据容器，用一个最小堆实现右边的数据容器。往堆中插入一个数据的时间效率是O(logn)。由于只需要O(1)时间就可以
 *      得到位于堆顶的数据，因此得到中位数的时间复杂度是O(1)。
 *      6.首先要保证数据平均分配到两个堆中，因此两个堆中数据的数目之差不能超过1。为了实现平均分配，可以在数据的总数目是偶数时把新数据插入最小堆，
 *      否则插入最大堆。
 *      7.还要保证最大堆中的所有数据都要小于最小堆中的数据。当数据的总数目是偶数时，按照前面的分配规则会把新的数据插入最小堆。如果此时这个新的
 *      数据比最大堆中的一些数据药效，那该怎么办呢？
 *          可以先把这个新的数据插入最大堆，接着把最大堆中最大的数字拿出来插入最小堆。由于最终插入最小堆的数字是原最大堆中最大的数字，这样
 *          就保证了最小堆中所有数字都大于最大堆中的数字。
 * @Author Garvey
 * @Date 2019/7/24 16:54
 */
public class GetMedianOfStream41 {

    /**
     * 最大堆：用于存放左半部分数据（需要获取最大值）
     */
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    /**
     * 最小堆：用于存放右半部分数据（需要获取最小值），默认根据
     */
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /* 当前数据流读入的元素个数 */
    private int count = 0;

    public void insert(Integer num) {
        if (num == null) {
            return;
        }

        if (count % 2 == 0) {
            maxHeap.offer(num);
            Integer maxNumOfMaxHeap = maxHeap.poll();

            if (maxNumOfMaxHeap != null) {
                minHeap.offer(maxNumOfMaxHeap);
            }
        } else {
            minHeap.offer(num);
            Integer minNumOfMinHeap = minHeap.poll();

            if (minNumOfMinHeap != null) {
                maxHeap.offer(minNumOfMinHeap);
            }
        }
        count++;
    }

    public Double getMedian() {
        if (count == 0) {
            return null;
        }

        double median = 0;

        if (count % 2 == 0) {
            median = (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            median = (double) minHeap.peek();
        }

        return median;
    }

    public static void main(String[] args) {
        GetMedianOfStream41 getMedianOfStream41 = new GetMedianOfStream41();

        for (int i = 0; i < 10; i++) {
            getMedianOfStream41.minHeap.offer(i);
            getMedianOfStream41.maxHeap.offer(i);
        }

        for (Integer i : getMedianOfStream41.minHeap) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (Integer i : getMedianOfStream41.maxHeap) {
            System.out.print(i + " ");
        }

        System.out.println();

        while (getMedianOfStream41.minHeap.size() > 0) {
            System.out.print(getMedianOfStream41.minHeap.poll() + " ");
        }

        System.out.println();

        while (getMedianOfStream41.maxHeap.size() > 0) {
            System.out.print(getMedianOfStream41.maxHeap.poll() + " ");
        }
    }

}
