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
        if (matrix == null || rows < 0 || cols < 0 || str == null){
            return false;
        }
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                int[] pathLen = new int[1];
                boolean[] visitedArray = new boolean[rows * cols];
                if (hasPathCore(matrix, rows, cols, str, i, j, pathLen, visitedArray)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int i, int j,
                                       int[] pathLen, boolean[] visitedArray) {
        if (pathLen[0] == str.length){
            return true;
        }
        if (i < 0 || i >= rows || j < 0 || j>=cols){
            return false;
        }
        boolean hasPath = false;
        int where = i*cols+j;
        if (!visitedArray[where] && matrix[where] == str[pathLen[0]]){
            pathLen[0]++;
            visitedArray[where] = true;
            hasPath = hasPathCore(matrix, rows, cols, str, i+1, j, pathLen, visitedArray)
                    || hasPathCore(matrix, rows, cols, str, i-1, j, pathLen, visitedArray)
                    || hasPathCore(matrix, rows, cols, str, i, j+1, pathLen, visitedArray)
                    ||hasPathCore(matrix, rows, cols, str, i, j-1, pathLen, visitedArray);
            if (!hasPath){
                pathLen[0]--;
                visitedArray[where] = false;
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