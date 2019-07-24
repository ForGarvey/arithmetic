package com.garvey.arithmetic.offer.efficiency;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Description 40
 *  最小的k个数：
 *      输入n个整数，找出其中最小的k个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *      1.排序算法：最简单的思路莫过于把输入的n个整数排序，排序之后位于最前面的k个数就是最小的k个数。这种思路的时间复杂度是O(nlogn)，且要修改原数组。
 *      2.快速选择算法：利用快速排序，如果基于数组的第k个数字来调整，则使得比第k个数字小的所有数字都位于数组的左边，比第k个数字大的所有数字都位于数组的右边。
 *      这样调整之后，位于数组中左边的k个数字就是最小的k个数字（这k个数字不一定是排序的）。时间复杂度O(n)，要修改原数组。
 *      3.数据容器：先创建一个大小为k的数据容器来存储最小的k个数字，接下来每次从输入的n个整数中读入一个数。如果容器中已有的数字少于k个，则直接把这次读入的整数放入容器之中；
 *      如果容器中已有k个数字了，也就是容器已满，此时我们不能再插入新的数字而只能替换已有的数字。找出这已有的k个数中的最大值，然后拿这次待插入的整数和最大值进行比较。
 *          ① 如果待插入的值比当前已有的最大值小，则用这个数替换当前已有的最大值；
 *          ② 如果待插入的值比当前已有的最大值还要大，那么这个数不可能是最小的k个整数之一，于是我们可以抛弃这个数。
 *          ③ 时间复杂度O(nlogk)，特别适合处理海量数据。
 *          ④ 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
 *          ⑤ 维护一个大小为k的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于k，那么需要将大顶堆的堆顶元素去除。
 * @Author Garvey
 * @Date 2019/7/24 11:36
 */
public class GetLeastNumbers40 {


    /**
     * 数据容器：优先队列  O(NlogK) + O(K)
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        if (input == null || input.length <= 0 || k <=0 || k > input.length) {
            return new ArrayList<>();
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : input) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                if (queue.peek() != null && queue.peek() > num) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        return new ArrayList<>(queue);
    }


    /**
     * 快速选择：O(N) + O(1)、只有当允许修改数组元素时才可以使用
     *  快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，
     *  此时 a[j] 就是数组的第 j 大元素。可以利用这个特性找出数组的第 K 个元素，这种找第 K 个元素的算法称为快速选择算法。
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers1(int[] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (input == null || input.length <=0 || k <= 0 || k > input.length) {
            return ret;
        }

        findKthSmallest(input, k - 1);
        // findKthSmallest 会改变数组，使得前k个数都是最小的k个数
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }

    public void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            }
            if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
    }

    private int partition(int[] nums, int l, int h) {
        // 快速排序
        int p = nums[l];
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) {};
            while (j != l && nums[--j] > p) {};
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
