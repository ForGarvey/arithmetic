package com.garvey.arithmetic.leetcode.easy;

import com.garvey.arithmetic.offer.TreeNode;

import java.util.Objects;

/**
 * @Description 二叉搜索树的范围和
 * @Author Garvey
 * @Date 2019-10-02 10:38
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (Objects.isNull(root)) {
            return 0;
        }

        int sum = 0;

        if (root.val >= L && root.val <= R) {
            sum += root.val;
            sum += rangeSumBST(root.left, L, R);
            sum += rangeSumBST(root.right, L, R);
        } else if (root.val < L) {
            sum += rangeSumBST(root.right, L, R);
        } else {
            sum += rangeSumBST(root.left, L, R);
        }

        return sum;
    }
}
