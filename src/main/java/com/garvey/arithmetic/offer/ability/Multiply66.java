package com.garvey.arithmetic.offer.ability;

/**
 * @Description 66
 *  构建乘积数组：
 *      给定一个数组A[0,1,...,n-1]，请构建一个数组B[0,1,...,n-1]，其中B中的元素
 *      B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *      1.如果没有不能使用除法的限制，也要注意A[i]等于0的情况。
 *      2.现在要求不能使用除法，一种直观的解法是用连乘n-1个数字得到B[i]，显然这种方法需要O(n²)的时间构建整个数组B。
 *      3.还有一种解法是把B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]看成A[0]*A[1]*...*A[i-1]和A[i+1]*...*A[n-2]*A[n-1]
 *      两部分的乘积。因此，数组B可以用一个矩阵来创建（左上角到右下角的对角线的值均为1）。
 *      4.不妨定义C[i]=A[0]*A[1]*...*A[i-1]，D[i]=A[i+1]*...*A[n-2]*A[n-1]。
 *          ① C[i]可以用自上而下的顺序计算出来，即C[i]=C[i-1]*A[i-1]。
 *          ② D[i]可以用自下而上的顺序计算出来，即D[i]=D[i+1]*A[i+1]。
 * @Author Garvey
 * @Date 2019/8/19 19:36
 */
public class Multiply66 {

    public int[] multiply(int[] arrA) {
        if (arrA == null || arrA.length <= 0) {
            return null;
        }

        int length = arrA.length;
        int[] arrB = new int[length];

        // 从左往右累乘算出C[i]
        for (int i = 0, temp = 1; i < length; temp *= arrA[i], i++) {
            arrB[i] = temp;
        }

        //  从右往左累乘D[i]得到B[i]
        for (int i = length - 1, temp = 1; i >= 0; temp *= arrA[i], i--) {
            arrB[i] *= temp;
        }

        return arrB;
    }
}
