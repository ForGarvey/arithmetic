package com.garvey.arithmetic.offer.thinking;

import com.garvey.arithmetic.offer.TreeNode;

import java.util.ArrayList;

/**
 * @Description 34
 *  二叉树中和为某一值的路径：
 *      输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *      1.由于路径是从根节点出发到叶节点，也就是说路径总是以根节点为起始点，因此我们首先需要遍历根节点。
 *      在树的前序、中序、后序3种遍历方式中，只有前序遍历是首先访问根节点的。
 *      2.当用前序遍历的方式访问到某一节点时，我们把该节点添加到路径上，并累加该节点的值：
 *          ① 如果该节点为叶节点，并且路径中节点值的和刚好等于输入的整数，则当前路径符合要求。
 *          ② 如果当前节点不是叶节点，则继续访问它的子节点。当前子节点访问结束后，递归函数将自动回到它的父节点。
 *          ③ 因此，我们在函数退出之前要在路径上删除当前节点并减去当前节点的值，以确保返回父节点时路径刚好是从根节点到父节点。
 *      3.不难看出保存路径的数据结构实际上就是一个栈，因此路径要与递归函数调用状态一直，而递归调用的本质就是一个压栈和出栈的过程。
 *      4.思路类似于回溯法：回溯法在一次搜索结束时需要进行回溯（回退），将这一次搜索过程中设置的状态进行清除，从而开始一次新的搜索过程。
 *      5.根据题目要求，这里我们使用ArrayList<Integer>保存路径
 * @Author Garvey
 * @Date 2019/7/17 10:07
 */
public class FindPathOfBinaryTree34 {

    private ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        find(root, target, new ArrayList<>());
        return list;
    }

    private void find(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            // 要新建数组保存
            list.add(new ArrayList<>(path));
        } else {
            find(node.left, target, path);
            find(node.right, target, path);
        }
        // 回溯
        path.remove(path.size() - 1);
    }
}
