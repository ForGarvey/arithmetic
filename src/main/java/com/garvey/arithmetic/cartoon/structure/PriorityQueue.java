package com.garvey.arithmetic.cartoon.structure;

import java.util.Arrays;

/**
 * @Description 优先队列
 *      1.普通队列：先进先出（FIFO）。入队列，将新元素置于队尾；出队列，队头元素最先被移出。
 *      2.优先队列：
 *          ① 最大优先队列：无论入队顺序如何，都是当前最大的元素优先出队。
 *          ② 最小优先队列：无论入队顺序如何，都是当前最小的元素优先出队。
 *          ③ 因为最大堆的堆顶是整个堆中的最大元素，最小堆的堆顶是整个堆中的最小元素。
 *          所以我们可以用最大堆来实现最大优先队列，用最小堆实现最小优先队列。
 *          ④ 二叉堆节点"上浮"和"下沉"的时间复杂度都是O(logn)，所以优先队列入队和出队
 *          的时间复杂度也是O(logn)。
 * @Author Garvey
 * @Date 2019-09-03 22:56
 */
public class PriorityQueue {

    private int[] array;

    private int size;

    public PriorityQueue() {
        // 队列初始长度为32
        array = new int[32];
    }

    /**
     * 入队
     * @param key
     */
    public void enQueue(int key) {
        // 队列长度超出范围，扩容
        if (size >= array.length) {
            resize();
        }

        array[size++] = key;
        upAdjust();
    }

    /**
     * 出队
     * @return
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if (size <= 0) {
            throw new Exception("the queue is empty !");
        }

        // 获取堆顶元素
        int head = array[0];
        // 让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
     * "上浮"调整
     */
    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        // temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];

        while (childIndex > 0 && temp > array[parentIndex]) {
            // 无须真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * "下沉"调整
     */
    private void downAdjust() {
        // temp保存父节点的值，用于最后的赋值
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;

        while (childIndex < size) {
            // 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            // 如果父节点大于任何一个孩子的值，直接跳出
            if (temp >= array[childIndex]) {
                break;
            }

            // 无须真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 队列扩容
     */
    private void resize() {
        // 队列容量翻倍
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println("出队元素：" + priorityQueue.deQueue());
    }
}
