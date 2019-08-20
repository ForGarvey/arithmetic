package com.garvey.arithmetic.offer.example;

import com.garvey.arithmetic.offer.TreeNode;

/**
 * @Description 68
 *  树中两个节点的最低公共祖先：
 *      1.二叉查找树中，两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val。
 *      2.普通二叉树中，在左右子树中查找是否存在 p 或者 q，如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。
 * @Author Garvey
 * @Date 2019/8/20 13:57
 */
public class LowestCommonAncestor68 {

    /**
     * 二叉查找树中两个节点的最低公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor1(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor1(root.right, p, q);
        }

        return root;
    }

    /**
     * 普通二叉树中两个节点的最低公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        return left == null ? right : right == null ? left : root;
    }

}
