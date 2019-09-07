package com.garvey.arithmetic.cartoon.structure;

import java.util.Arrays;

/**
 * @Description 二叉堆
 *      1.二叉堆本质上是一种完全二叉树，它分为两个类型：
 *          ① 最大堆：最大堆的任何一个父节点的值，都大于或等于它左、右孩子节点的值。
 *          ② 最小堆：最小堆的任何一个父节点的值，都小于或等于它左、右孩子节点的值。
 *      2.二叉堆的根节点叫作堆顶。
 *      3.最大堆和最小堆的特点决定了：最大堆的堆顶是整个堆中的最大元素；最小堆的堆顶是整个堆中的最小元素。
 *      4.二叉堆的三种操作（这几种操作都基于堆的自我调整）：
 *          ① 插入节点：单一节点的"上浮"，平均交换次数是堆高度的一半，时间复杂度为O(logn)。
 *          ② 删除节点：单一节点的"下沉"，平均交换次数是堆高度的一半，时间复杂度为O(logn)。
 *          ③ 构建二叉树：需要所有非叶子节点依次"下沉"，时间复杂度为O(n)。
 *      5.二叉堆虽然是一个完全二叉树，但它的存储方式并不是链式存储，而是顺序存储。换句话说，二叉堆的所有节点都存储在数组中。
 *      6.假设父节点的下标是parent，那么它的左孩子下标就是2*parent+1，右孩子下标就是2*parent+2。
 *      7.以下代码是以最小堆为例编写的。
 * @Author Garvey
 * @Date 2019-09-05 23:14
 */
public class BinaryHeap {

    /**
     * "上浮"调整
     * @param array     待调整的堆
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        // temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            // 无须真正交换，单项赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * "下沉"调整
     * @param array         待调整的堆
     * @param parentIndex   要"下沉"的父节点
     * @param length        堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }

            // 如果父节点小于任何一个孩子的值，则直接跳出
            if (temp <= array[childIndex]) {
                break;
            }

            // 无须真正交换，单项赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 构建堆
     * @param array  待调整的堆
     */
    public static void buildHeap(int[] array) {
        // 从最后一个非叶子节点开始，依次做"下沉"调整
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
