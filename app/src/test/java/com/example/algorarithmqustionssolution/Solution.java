package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings("unused")
public class Solution {

    public ListNode Merge(ListNode list1,ListNode list2) {
        return merge2(list1, list2);
    }

    public static ListNode merge2(ListNode head1, ListNode head2) {
        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2;
        }

        // 如果第二个链表为空，返回第一个链表头结点
        if (head2 == null) {
            return head1;
        }

        // 记录两个链表中头部较小的结点
        ListNode tmp = head1;
        if (tmp.val < head2.val) {
            // 如果第一个链表的头结点小，就递归处理第一个链表的下一个结点和第二个链表的头结点
            tmp.next = merge2(head1.next, head2);
        } else {
            // 如果第二个链表的头结点小，就递归处理第一个链表的头结点和第二个链表的头结点的下一个结点
            tmp = head2;
            tmp.next = merge2(head1, head2.next);
        }

        // 返回处理结果
        return tmp;
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