package com.garvey.arithmetic.offer.quality;

import com.garvey.arithmetic.offer.TreeNode;

/**
 * @Description 26
 *  树的子结构：
 *      输入两棵二叉树A和B，判断B是不是A的子结构。
 *      1.第一步，在树A中找到和树B的根节点的值一样的节点R。
 *      2.第二步，判断树A中以R为根节点的子树是不是包含和树B一样的结构。
 * @Author Garvey
 * @Date 2019/7/11 19:26
 */
public class HasSubtree26 {

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
}
