package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class Solution {

    private static ArrayList<Integer> mResultList = new ArrayList<>();

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        mResultList.clear();
        printFromToBottom(NodeTranslateUtil.toBinaryTreeNode(root));
        return mResultList;
    }

    /**
     * 从上往下打印出二叉树的每个结点，向一层的结点按照从左往右的顺序打印。
     * 例如下的二叉树，
     *       8
     *    /    \
     *   6     10
     *  /  \   / \
     * 5   7  9  11
     * 则依次打印出8、6、10、5、3 、9、11.
     *
     * @param root 树的结点
     */
    public static void printFromToBottom(BinaryTreeNode root) {
        if (root == null){
            return;
        }
        Queue<BinaryTreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            BinaryTreeNode node = nodeQueue.remove();
            mResultList.add(node.value);
            BinaryTreeNode leftNode = node.left;
            if (leftNode != null){
                nodeQueue.add(leftNode);
            }
            BinaryTreeNode rightNode = node.right;
            if (rightNode != null){
                nodeQueue.add(rightNode);
            }
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