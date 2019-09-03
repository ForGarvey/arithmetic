package com.garvey.arithmetic.cartoon.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Description 桶排序
 *      1.桶排序的性能并非绝对稳定。如果元素的分布极不均衡，在极端情况下，第一个桶有n-1个元素，
 *      最后一个桶中有1个元素。此时的时间复杂度将退化为O(nlogn)，而且还白白创建了许多空桶。
 *      平均时间复杂度：O(n)
 *      最坏时间复杂度：O(nlogn)
 *      空间复杂度：O(n)
 *      是否稳定排序：稳定。即值相同的元素在排序后仍然保持着排序前的顺序。
 * @Author Garvey
 * @Date 2019-09-02 23:10
 */
public class BucketSort {

    public static double[] bucketSort(double[] array) {
        // 1.得到数列的最大值和最小值，并算出差值d
        double max = array[0];
        double min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        double d = max - min;

        // 2.初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        // 3.遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < array.length; i++) {
            int num = (int) ((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }

        // 4.对每个桶内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            // JDK底层采用了归并排序或归并的优化版本
            Collections.sort(bucketList.get(i));
        }

        // 5.输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = new double[]{4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
