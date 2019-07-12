package com.garvey.arithmetic.offer.thinking;

import com.garvey.arithmetic.offer.TreeNode;

/**
 * @Description 28
 *  对称的二叉树：
 *      请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *      1.针对前序遍历定义一种对称的遍历算法，即先遍历父节点，再遍历它的右子节点，最后遍历它的左子节点。
 *      2.需要在遍历二叉树时把遇到的null也考虑进来，才能防止二叉树不是对称的，但前序遍历序列和对称前序遍历序列一样的情况。
 *      3.通过比较二叉树的前序遍历序列和对称前序遍历序列来判断二叉树是不是对称的。如果两个序列是一样的，那么二叉树就是对称的。
 * @Author Garvey
 * @Date 2019/7/12 16:38
 */
public class IsSymmetricalBinaryTree28 {

    public boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }

        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }

        if (pRoot1.val != pRoot2.val) {
            return false;
        }

        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }
}
