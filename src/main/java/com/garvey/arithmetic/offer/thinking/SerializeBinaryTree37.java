package com.garvey.arithmetic.offer.thinking;

import com.garvey.arithmetic.offer.TreeNode;

/**
 * @Description 37
 * 序列化二叉树：
 *      请实现两个函数，分别用来序列化和反序列化二叉树。
 * @Date 2019/7/20 20:55
 */
public class SerializeBinaryTree37 {

    private String deserializeStr;

    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    public TreeNode deserialize(String str) {
        deserializeStr = str;
        return deserialize();
    }

    private TreeNode deserialize() {
        if (deserializeStr == null || deserializeStr.length() == 0) {
            return null;
        }
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals("#")) {
            return null;
        }
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = deserialize();
        t.right = deserialize();
        return t;
    }
}
