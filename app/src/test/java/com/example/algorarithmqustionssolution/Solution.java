package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class Solution {

    /**
     * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中任意一格开始，每一步可以在矩阵中间向左、右、上、下移动一格。
     * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
     *
     * @param matrix 输入矩阵
     * @param rows   矩阵行数
     * @param cols   矩阵列数
     * @param str    要搜索的字符串
     * @return 是否找到 true是，false否
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 参数校验
        if (matrix == null || matrix.length != rows * cols || str == null || str.length < 1) {
            return false;
        }

        // 变量初始化
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        // 记录结果的数组，
        int[] pathLength = {0};
        // 以每一个点为起始进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, str, visited, i, j, pathLength)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 回溯搜索算法
     *
     * @param matrix     输入矩阵
     * @param rows       矩阵行数
     * @param cols       矩阵列数
     * @param str        要搜索的字符串
     * @param visited    访问标记数组
     * @param row        当前处理的行号
     * @param col        当前处理的列号
     * @param pathLength 已经处理的str中字符个数
     * @return 是否找到 true是，false否
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited,
                                       int row, int col, int[] pathLength) {

        if (pathLength[0] == str.length) {
            return true;
        }

        boolean hasPath = false;

        // 判断位置是否合法
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength[0]]
                && !visited[row * cols + col]) {

            visited[row * cols + col] = true;
            pathLength[0]++;

            // 按左上右下进行回溯
            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLength);

            if (!hasPath) {
                pathLength[0]--;
                visited[row * cols + col] = false;
            }

        }

        return hasPath;
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