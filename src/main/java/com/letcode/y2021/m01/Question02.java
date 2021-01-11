package com.letcode.y2021.m01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/1/11 15:44
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 * 示例：
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 */
public class Question02 {

    List<Integer> vals;

    /**
     * 通过排序的方式：
     * 思路：
     * 将树中所有节点的值写入数组，之后将数组排序。依次计算相邻数之间的差值，找出其中最小的值。
     * @param root
     * @return
     */
    public int minDiffInBSF(TreeNode root) {
        vals = new ArrayList<>();
        dfs(root);
        Collections.sort(vals);


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < vals.size() - 1; ++i) {
            ans = Math.min(ans, vals.get(i + 1) - vals.get(i));
        }

        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null)  return;
        vals.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
