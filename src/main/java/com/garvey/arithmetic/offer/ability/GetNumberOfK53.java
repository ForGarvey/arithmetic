package com.garvey.arithmetic.offer.ability;

/**
 * @Description 53.1
 *  在排序数组中查找数字：数字在排序数组中出现的次数
 *      统计一个数字在排序数组中出现的次数。例如，输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 *      1.顺序扫描：时间复杂度O(n)
 *      2.由于数组是排序的，所以利用二分查找算法在数组中找到第一个k和最后一个k，即可得到数字在该数组中出现的次数。时间复杂度：O(logN)
 * @Author Garvey
 * @Date 2019/8/2 15:28
 */
public class GetNumberOfK53 {

    public int getNumberOfK(int[] array, int k) {
        int number = 0;

        if (array != null && array.length > 0) {

            int firstIndex = getFirstKIndex(array, k, 0, array.length - 1);
            int lastIndex = getLastKIndex(array, k, 0, array.length - 1);

            if (lastIndex > -1 && lastIndex > -1) {
                number = lastIndex - firstIndex + 1;
            }
        }

        return number;
    }

    /**
     * 找到第一个k的索引值
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int getFirstKIndex(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midNum = array[mid];

        if (midNum == k) {
            if ((mid > 0 && array[mid - 1] != k) || mid == 0) {
                // 说明mid是数组中出现的第一个k的索引值
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (midNum > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return getFirstKIndex(array, k, start, end);
    }

    /**
     * 找到最后一个k的索引值
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int getLastKIndex(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int midNum = array[mid];

        if (midNum == k) {
            if ((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (midNum > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }

        return getLastKIndex(array, k, start, end);
    }

    public static void main(String[] args) {
        GetNumberOfK53 getNumberOfK53 = new GetNumberOfK53();
        System.out.println(getNumberOfK53.getNumberOfK(new int[]{1,2,3,3,3,3,4,5}, 3));
    }
}
