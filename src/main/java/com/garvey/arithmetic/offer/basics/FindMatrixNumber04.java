package com.garvey.arithmetic.offer.basics;

import java.util.Objects;

/**
 * @Description 04
 *  二维数组中的查找：
 *      给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *      （从右上角或左下角开始查找，这里采取右上角）
 * @Author Garvey
 * @Date 2019/4/29 16:38
 */
public class FindMatrixNumber04 {

    public static void main(String[] args) {
        int target = 7;
        int[][] matrix = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean existTarget = find(target, matrix);
        if (existTarget) {
            System.out.println("二维数组中存在" + target);
        } else {
            System.out.println("数组为空或数组不存在" + target);
        }
    }

    /**
     * 判断这个数是否在该二维数组中
     * @param target    要判断的数字
     * @param matrix    二维数组
     * @return
     */
    public static boolean find(int target, int[][] matrix) {
        if (Objects.isNull(matrix) || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 从右上角开始判断
        int r = 0;
        int c = cols - 1;

        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }

        }

        return false;
    }
}
