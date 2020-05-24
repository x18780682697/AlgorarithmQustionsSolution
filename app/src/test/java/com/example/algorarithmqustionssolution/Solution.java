package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class Solution {

    public boolean VerifySquenceOfBST(int [] sequence) {
        return verifySequenceOfBST(sequence);
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。
     *
     * @param sequence 某二叉搜索树的后序遍历的结果
     * @return true：该数组是某二叉搜索树的后序遍历的结果。false：不是
     */
    public static boolean verifySequenceOfBST(int[] sequence) {

        // 输入的数组不能为空，并且有数据
        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        // 有数据，就调用辅助方法
        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * @param sequence 某二叉搜索树的后序遍历的结果
     * @param start    处理的开始位置
     * @param end      处理的结束位置
     * @return true：该数组是某二叉搜索树的后序遍历的结果。false：不是
     */
    public static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if (start >= end){
            return true;
        }
        int index = start;
        while (index < end-1 && sequence[index] < sequence[end]){
            index++;
        }
        int rStart = index;
        while (index < end-1 && sequence[index] > sequence[end]){
            index++;
        }
        if (index == end-1){
            return verifySequenceOfBST(sequence, start, rStart-1)
                    && verifySequenceOfBST(sequence, rStart, end-1);
        }else{
            return false;
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