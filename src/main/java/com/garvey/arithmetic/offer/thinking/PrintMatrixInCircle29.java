package com.garvey.arithmetic.offer.thinking;

import java.util.ArrayList;

/**
 * @Description 29
 *  顺时针打印矩阵：
 *      输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *      1.打印第一圈的左上角的坐标是(0,0)，第二圈的左上角的坐标是(1,1)，以此类推。
 *      2.我们注意到，左上角的坐标中行标和列标总是相同的，于是可以在矩阵中选取左上角为(start,start)的一圈作为我们分析的目标。
 *      3.我们可以把打印一圈分为四步：
 *          a.从左到右打印一行
 *          b.从上到下打印一列
 *          c.从右到左打印一行
 *          d.从下到上打印一列
 *      4.每一步我们根据起始坐标和终止坐标用一个循环就能打印出一行或者一列。
 *      5.最后一圈有可能退化成只有一行、只有一列，甚至只有一个数字。
 *      6.第一步总是需要的，因为打印一圈至少有一步。如果只有一行，那么就不用第二步了。也就是需要第二步的前提是终止行号大于起始行号。
 *      需要第三步打印的前提条件是圈内至少有两行两列，也就是说除了要求终止行号大于起始行号，还要求终止列号大于起始列号。
 *      同理，需要打印第四步的前提条件是至少有三行两列，因为要求终止行号比起始行号至少大2，同时终止列号大于起始列号。
 * @Author Garvey
 * @Date 2019-07-13 15:19
 */
public class PrintMatrixInCircle29 {

    public ArrayList<Integer> printMatrixInCircle(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                ret.add(matrix[r1][i]);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                ret.add(matrix[i][c2]);
            }
            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    ret.add(matrix[r2][i]);
                }
            }
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    ret.add(matrix[i][c1]);
                }
            }
            r1++; r2--; c1++; c2--;
        }
        return ret;
    }
}
