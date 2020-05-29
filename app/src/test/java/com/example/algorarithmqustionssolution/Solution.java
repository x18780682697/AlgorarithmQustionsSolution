package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class Solution {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        return getNext(pNode);
    }

    public static TreeLinkNode getNext(TreeLinkNode node) {
        if (node == null) {
            return null;
        }

        // 保存要查找的下一个节点
        TreeLinkNode target = null;

        if (node.right != null) {
            target = node.right;
            while (target.left != null) {
                target = target.left;
            }

            return target;
        } else if (node.next != null){
            target = node.next;
            TreeLinkNode cur = node;
            // 如果父新结点不为空，并且，子结点不是父结点的左孩子
            while (target != null && target.left != cur) {
                cur = target;
                target = target.next;

            }

            return target;
        }

        return null;
    }

    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
        public BinaryTreeNode parent;
    }

}


/**
 * TreeNode和BinaryTreeNode之间的转换工具
 */
class NodeTranslateUtil {
    /**
     * 转换为TreeNode
     */
    public static TreeLinkNode toTreeNode(Solution.BinaryTreeNode node){
        TreeLinkNode treeNode = null;
        if (node == null){
            return null;
        }else{
            treeNode = new TreeLinkNode(node.value);
            treeNode.left = toTreeNode(node.left);
            treeNode.right = toTreeNode(node.right);
            treeNode.next = toTreeNode(node.parent);
        }
        return treeNode;
    }

    /**
     * 转换为BinaryTreeNode
     */
    public static Solution.BinaryTreeNode toBinaryTreeNode(TreeLinkNode node){
        Solution.BinaryTreeNode binaryTreeNode = null;
        if (node == null){
            return null;
        }else{
            binaryTreeNode = new Solution.BinaryTreeNode();
            binaryTreeNode.value = node.val;
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
class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next = null;
    TreeLinkNode(int x) { val = x; }
}