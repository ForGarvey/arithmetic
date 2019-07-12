package com.garvey.arithmetic.offer.thinking;

import com.garvey.arithmetic.offer.TreeNode;

/**
 * @Description 27
 *  二叉树的镜像：
 *      请完成一个函数，输入一棵二叉树，该函数输出它的镜像。
 *      1.二叉树与镜像的根节点相同，但它们的左、右两个子节点交换了位置。
 *      2.求一棵树的镜像的过程：
 *          ① 先前序遍历这棵树的每个节点，如果遍历到的节点有子节点，就交换它的两个子节点。
 *          ② 当交换完所有非叶节点的左、右子节点之后，就得到了树的镜像。
 * @Author Garvey
 * @Date 2019/7/12 10:31
 */
public class MirrorBinaryTree27 {

    public void mirrorRecursively(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        swap(root);
        mirrorRecursively(root.left);
        mirrorRecursively(root.right);
    }

    private void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
