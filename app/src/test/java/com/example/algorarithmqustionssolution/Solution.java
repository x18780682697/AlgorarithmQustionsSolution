package com.example.algorarithmqustionssolution;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class Solution {

    public int[] multiply(int[] A) {
        return multiplyCore(A);
    }

    public static int[] multiplyCore(int[] data) {
        if (data == null || data.length < 2) {
            return null;
        }

        int[] result = new int[data.length];
        int tmpBelow = 1;
        // 计算下三角部分的乘积，自上而下累乘
        for (int i=0; i<data.length; i++){
            tmpBelow *= (i==0 ? 1 : data[i-1]);
            result[i] = tmpBelow;
        }
        // 计算上三角部分的乘积，自下而上类累乘
        int tmpAbove = 1;
        for (int i=data.length-1; i>=0; i--){
            tmpAbove *= (i==data.length-1 ? 1 : data[i+1]);
            result[i] *= tmpAbove;
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