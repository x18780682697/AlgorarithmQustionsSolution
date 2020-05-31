package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class Solution {

    /**
     * 题目：地上有个m行n列的方格。一个机器人从坐标(0,0)的格子开始移动，
     * 它每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数
     * 位之和大于k的格子。例如，当k为18时，机器人能够进入方格(35,37)，
     * 因为3+5+3+7=18.但它不能进入方格(35,38)，因为3+5+3+8=19.
     * 请问该机器人能够达到多少格子？
     *
     * @param threshold 约束值
     * @param rows      方格的行数
     * @param cols      方格的列数
     * @return 最多可走的方格
     */
    public static int movingCount(int threshold, int rows, int cols) {
        if (rows < 0 || cols < 0){
            return 0;
        }
        boolean[] visitedArray = new boolean[rows*cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visitedArray);
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visitedArray) {
        if (row < 0 || row >= rows || col < 0 || col >= cols){
            return 0;
        }
        int count = 0;
        int where = row*cols+col;
        if (!visitedArray[where] && (countDigitSum(row) + countDigitSum(col)) <= threshold){
            visitedArray[where] = true;
            count =  1 + movingCountCore(threshold, rows, cols, row+1, col, visitedArray)
                    + movingCountCore(threshold, rows, cols, row-1, col, visitedArray)
                    + movingCountCore(threshold, rows, cols, row, col+1, visitedArray)
                    + movingCountCore(threshold, rows, cols, row, col-1, visitedArray);
        }
        return count;
    }

    private static int countDigitSum(int num) {
        int result = 0;
        int tmpVal = num;
        while (tmpVal > 0){
            result += tmpVal % 10;
            tmpVal = tmpVal / 10;
        }
        return result;
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