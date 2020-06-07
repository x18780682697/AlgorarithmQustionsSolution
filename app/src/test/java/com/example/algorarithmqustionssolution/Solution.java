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
        int inputNum = input.length;
        int outputNum = output.length;
        int index = partition(input, 0, inputNum-1);
        int start = 0, end = inputNum-1;
        // 根据上次分区结果动态调整分区范围，使得最终左边分区的大小刚好调整为所需大小
        while (index != outputNum - 1){
            if (index < outputNum - 1){
                start = index + 1;
            }else{
                end = index - 1;
            }
            index = partition(input, start, end);
        }
        System.arraycopy(input, 0,  output, 0, outputNum);
    }

    /**
     * 分区算法
     *
     * 函数调用效果说明：
     * 以input[start]的值作为临界值，使数组分为两个区域
     * 左边区域总是小于临界值，右边区域总是大于临界值，两个子区域均不保证数据有序
     *
     * @param input 输入数组
     * @param start 开始下标
     * @param end   结束下标
     * @return 分区位置
     */
    public static int partition(int[] input, int start, int end) {
        int criticalVal = input[start];
        while (start < end){
            // 找到大于临界值的值，立即往前移动，移动的值此前移走的start值的位置
            while (start < end && input[end] >= criticalVal){
                end--;
            }
            input[start] = input[end];
            // 找到小于临界值的值，立即往后移动，移动的位置是此前移走的end值的位置
            while (start < end && input[start] <= criticalVal){
                start++;
            }
            input[end] = input[start];
        }
        // 将临界值从外存空间移动到临界位置
        input[start] = criticalVal;
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