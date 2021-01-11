package com.letcode.y2021.m01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/1/8 10:13
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 最大深度 3
 */
public class Question01 {
    public static void main(String[] args) {
        System.out.println(2 % 6);
    }

    /**
     * 递归实现
     *
     * @param root
     * @return 思路与算法
     * <p>
     * 如果我们知道了左子树和右子树的最大深度 l 和 r，那么该二叉树的最大深度即为
     * <p>
     * max(l,r)+1
     * <p>
     * 而左子树和右子树的最大深度又可以以同样的方式进行计算。因此我们在计算当前二叉树的最大深度时，可以先递归计算出其左子树和右子树的最大深度，然后在 O(1)O(1)O(1) 时间内计算出当前二叉树的最大深度。递归在访问到空节点时退出。
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
        // return root == null ? 0 : Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }


    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth2(root.left);
        int rightHeight = maxDepth2(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    /**
     * 非递归的方法实现
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

}
