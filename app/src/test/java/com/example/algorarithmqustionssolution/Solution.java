package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("unused")
public class Solution {

    private ArrayList<Integer> sResultList = new ArrayList<>();

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        sResultList.clear();
        if (input != null && k > 0 && k <= input.length){
            int[] output = new int[k];
            getLeastNumbers(input, output);
            for (int value: output){
                sResultList.add(value);
            }
        }
        return sResultList;
    }

    /**
     * 题目： 输入n个整数，找出其中最小的k个数。
     * 【第一种解法】
     * @param input  输入数组
     * @param output 输出数组
     */
    public static void getLeastNumbers(int[] input, int[] output) {

        if (input == null || output == null || output.length <= 0 || input.length < output.length) {
            throw new IllegalArgumentException("Invalid args");
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        int target = output.length - 1;

        while (index != target) {
            if (index < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(input, start, end);
        }

        System.arraycopy(input, 0, output, 0, output.length);
    }

    /**
     * 分区算法
     *
     * @param input 输入数组
     * @param start 开始下标
     * @param end   结束下标
     * @return 分区位置
     */
    private static int partition(int[] input, int start, int end) {
        int tmp = input[start];

        while (start < end) {
            while (start < end && input[end] >= tmp) {
                end--;
            }
            input[start] = input[end];

            while (start < end && input[start] <= tmp) {
                start++;
            }
            input[end] = input[start];
        }

        input[start] = tmp;
        return start;
    }

    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode {
        public int val;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
        public BinaryTreeNode parent;
        public TreeNode origin;
    }

}


/**
 * TreeNode和BinaryTreeNode之间的转换工具
 */
class NodeTranslateUtil {
    /**
     * 转换为TreeNode
     */
    public static TreeNode toTreeNode(Solution.BinaryTreeNode node){
        TreeNode treeNode = null;
        if (node == null){
            return null;
        }else{
            treeNode = new TreeNode(node.val);
            treeNode.left = toTreeNode(node.left);
            treeNode.right = toTreeNode(node.right);
            treeNode.next = toTreeNode(node.parent);
        }
        return treeNode;
    }

    /**
     * 转换为BinaryTreeNode
     */
    public static Solution.BinaryTreeNode toBinaryTreeNode(TreeNode node){
        Solution.BinaryTreeNode binaryTreeNode = null;
        if (node == null){
            return null;
        }else{
            binaryTreeNode = new Solution.BinaryTreeNode();
            binaryTreeNode.origin = node;
            binaryTreeNode.val = node.val;
            binaryTreeNode.left = toBinaryTreeNode(node.left);
            binaryTreeNode.right = toBinaryTreeNode(node.right);
            binaryTreeNode.parent = toBinaryTreeNode(node.next);
        }
        return binaryTreeNode;
    }
}

/**
 * 牛客网二叉树定义
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next = null;
    TreeNode(int x) { val = x; }
}