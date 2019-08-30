package com.garvey.arithmetic.cartoon;

/**
 * @Description 堆排序
 *      1.把无序数组构建成二叉堆。需要从小到大排序，则构建成最大堆；需要从大到小排序，则构建成最小堆。
 *      2.循环删除堆顶元素，替换到二叉堆的末尾，调整堆产生新的堆顶。
 *      3.二叉堆虽然是一个完全二叉树，但它的存储方式并不是链式存储，而是顺序存储。换句话说，二叉堆的所有节点都存储在数组中。
 *      4.假设父节点的下标是parent，那么它的左孩子下标就是2*parent+1，右孩子下标就是2*parent+2。
 *      平均时间复杂度：O(nlogn)
 *      最坏时间复杂度：O(nlogn)
 *      空间复杂度：O(1)
 *      是否稳定排序：不稳定。即值相同的元素在排序后不能保持排序前的顺序。
 * @Author Garvey
 * @Date 2019-08-30 22:38
 */
public class HeapSort {

    /**
     * "下沉"调整
     * @param array         待调整的堆
     * @param parentIndex   要"下沉"的父节点
     * @param length        堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
    }

}
