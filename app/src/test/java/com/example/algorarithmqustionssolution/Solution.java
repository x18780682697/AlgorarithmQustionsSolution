package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("unused")
public class Solution {

    public static ListNode findMeetingNode(ListNode head) {
        ListNode fast= head, slow = head;
        while (fast != null && slow != null){
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            }
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        return fast;
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        // 寻找相遇节点
        ListNode meetingNode = findMeetingNode(pHead);
        if (meetingNode == null){
            return null;
        }
        // 计数环中节点数量
        int nodeNum = 1;
        ListNode nodePointer = meetingNode;
        while (nodePointer != null){
            nodePointer = nodePointer.next;
            if (nodePointer == meetingNode){
                break;
            }
            nodeNum++;
        }
        // 根据节点数量找环入口
        ListNode front=pHead, back = pHead;
        for (int i=0; i<nodeNum; i++){
            front = front.next;
        }
        while (front != back){
            front = front.next;
            back = back.next;
            if (front == back){
                break;
            }
        }
        return front;
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