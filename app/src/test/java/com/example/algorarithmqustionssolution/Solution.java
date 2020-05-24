package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class Solution {

    private static ArrayList<ArrayList<Integer>> sResultList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        sResultList.clear();
        findPath(NodeTranslateUtil.toBinaryTreeNode(root), target);
        return sResultList;
    }

    /**
     * 输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。
     * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     *
     * @param root        树的根结点
     * @param expectedSum 要求的路径和
     */
    public static void findPath(BinaryTreeNode root, int expectedSum) {
        // 创建一个链表，用于存放根结点到当前处理结点的所经过的结点
        List<Integer> list = new ArrayList<>();

        // 如果根结点不为空，就调用辅助处理方法
        if (root != null) {
            findPath(root, 0, expectedSum, list);
        }
    }

    /**
     * @param root        当前要处理的结点
     * @param curSum      当前记录的和（还未加上当前结点的值）
     * @param expectedSum 要求的路径和
     * @param result      根结点到当前处理结点的所经过的结点，（还未包括当前结点）
     */
    public static void findPath(BinaryTreeNode root, int curSum, int expectedSum, List<Integer> result) {

        // 如果结点不为空就进行处理
        if (root != null) {
            // 加上当前结点的值
            curSum += root.value;
            // 将当前结点入队
            result.add(root.value);
            // 如果当前结点的值小于期望的和
            if (curSum < expectedSum) {
                // 递归处理左子树
                findPath(root.left, curSum, expectedSum, result);
                // 递归处理右子树
                findPath(root.right, curSum, expectedSum, result);
            }
            // 如果当前和与期望的和相等
            else if (curSum == expectedSum) {
                // 当前结点是叶结点，则输出结果
                if (root.left == null && root.right == null) {
                    System.out.println(result);
                    sResultList.add(new ArrayList<>(result));
                }
            }
            // 移除当前结点
            result.remove(result.size() - 1);
        }
    }

    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
    }

    /**
     * TreeNode和BinaryTreeNode之间的转换工具
     */
    public static class NodeTranslateUtil {
        /**
         * 转换为TreeNode
         */
        public static TreeNode toTreeNode(BinaryTreeNode node){
            TreeNode treeNode = null;
            if (node == null){
                return null;
            }else{
                treeNode = new TreeNode(node.value);
                treeNode.left = toTreeNode(node.left);
                treeNode.right = toTreeNode(node.right);
            }
            return treeNode;
        }

        /**
         * 转换为BinaryTreeNode
         */
        public static BinaryTreeNode toBinaryTreeNode(TreeNode node){
            BinaryTreeNode binaryTreeNode = null;
            if (node == null){
                return null;
            }else{
                binaryTreeNode = new BinaryTreeNode();
                binaryTreeNode.value = node.val;
                binaryTreeNode.left = toBinaryTreeNode(node.left);
                binaryTreeNode.right = toBinaryTreeNode(node.right);
            }
            return binaryTreeNode;
        }
    }

}

/**
 * 牛客网二叉树定义
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}