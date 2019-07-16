package com.garvey.arithmetic.offer.thinking;

/**
 * @Description 33
 *  二叉搜索树的后序遍历序列：
 *      输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。
 *      假设输入的数组的任意两个数字都互不相同。例如，输入数组{5,7,6,9,11,10,8}，则返回true。如果输入的数组是{7,4,6,5}，则由于没有哪颗二叉搜索树的后序遍历结果是这个序列，因此返回false。
 *      1.在后序遍历得到的序列中，最后一个数字是树的根节点的值。数组中前面的数字可以分为两个部分：
 *          ① 第一部分是左子树节点的值，它们都比根节点的值小；
 *          ② 第二部分是右子树节点的值，它们都比根节点的值大。
 *      2.以数组{5,7,6,9,11,10,8}为例，后序遍历结果的最后一个数字8就是根节点的值。
 *      在这个数组中，前3个数字5、7和6都比8小，是值为8的节点的左子树节点；
 *      后3个数字9、11和10都比8大，是值为8的节点的右子树节点。
 *      3.本质上是递归判断父序列、子序列是不是都为二叉搜索树
 * @Author Garvey
 * @Date 2019/7/16 19:16
 */
public class VerifySquenceOfBST33 {

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        // 说明子节点数为1个或0个，已经不需判断是否为二叉搜索树
        if (last - first <= 1) {
            return true;
        }

        // 二叉搜索树的根节点
        int root = sequence[last];

        // 左子树和右子树的分界线
        int boundaryIndex = first;

        while (boundaryIndex < last && sequence[boundaryIndex] < root) {
            boundaryIndex++;
        }

        for (int i = boundaryIndex; i < last; i++) {
            if (sequence[i] < root) {
                // 二叉搜索树右子树节点必须比根节点大
                return false;
            }
        }

        return verify(sequence, 0, boundaryIndex - 1) && verify(sequence, boundaryIndex, last - 1);
    }
}
