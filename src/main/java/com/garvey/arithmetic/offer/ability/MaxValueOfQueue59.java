package com.garvey.arithmetic.offer.ability;

import java.util.PriorityQueue;

/**
 * @Description 59.2
 *  队列的最大值：
 *      请定义一个队列并实现函数max得到队列里的最大值，要求函数max、pushBack和popFront的时间复杂度都是O(1)。
 * @Author Garvey
 * @Date 2019-08-07 20:59
 */
public class MaxValueOfQueue59 {

    /**
     * 最大堆
     */
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public Integer max() {
        return maxHeap.peek();
    }

    public void pushBack(Integer num) {
        maxHeap.offer(num);
    }

    public Integer popFront() {
        return maxHeap.poll();
    }


}
