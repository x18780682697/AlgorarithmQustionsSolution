package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings("unused")
public class Solution {

    public RandomListNode Clone(RandomListNode pHead)
    {
        return clone(pHead);
    }

    /**
     * 实现函复制一个复杂链表。在复杂链表中，每个结点除了有一个next字段指向下一个结点外，
     * 还有一个sibling字段指向链表中的任意结点或者NULL
     *
     * @param head 链表表头结点
     * @return 复制结点的头结点
     */
    public static RandomListNode clone(RandomListNode head) {
        // 如果链表为空就直接返回空
        if (head == null) {
            return null;
        }

        // 先复制结点
        cloneNodes(head);
        // 再链接sibling字段
        connectNodes(head);
        // 将整个链表拆分，返回复制链表的头结点
        return reconnectNodes(head);
    }

    /**
     * 复制一个链表，并且将复制后的结点插入到被复制的结点后面，只链接复制结点的next字段
     *
     * @param head 待复制链表的头结点
     */
    public static void cloneNodes(RandomListNode head) {
        // 如果链表不空，进行复制操作
        while (head != null) {
            // 创建一个新的结点
            RandomListNode tmp = new RandomListNode(head.label);
            // 将被复制结点的值传给复制结点
            tmp.label = head.label;
            // 复制结点的next指向下一个要被复制的结点
            tmp.next = head.next;
            // 被复制结点的next指向复制结点
            head.next = tmp;
            // 到些处就已经完成了一个结点的复制并且插入到被复制结点的后面
            // heed指向下一个被复制结点的位置
            head = tmp.next;
        }
    }

    /**
     * 设置复制结点的sibling字段
     *
     * @param head 链表的头结
     */
    public static void connectNodes(RandomListNode head) {
        // 如链表不为空
        while (head != null) {
            // 当前处理的结点sibling字段不为空，则要设置其复制结点的sibling字段
            if (head.random != null) {
                // 复制结点的sibling指向被复制结点的sibling字段的下一个结点
                // head.next：表求复制结点，
                // head.sibling：表示被复制结点的sibling所指向的结点，
                // 它的下一个结点就是它的复制结点
                head.next.random = head.random.next;
            }
            // 指向下一个要处理的复制结点
            head = head.next.next;
        }
    }

    /**
     * 刚复制结点和被复制结点拆开，还原被复制的链表，同时生成复制链表
     *
     * @param head 链表的头结点
     * @return 复制链表的头结点
     */
    public static RandomListNode reconnectNodes(RandomListNode head) {

        // 当链表为空就直接返回空
        if (head == null) {
            return null;
        }

        RandomListNode pointer = head;
        RandomListNode oldTailNode = pointer;
        pointer = pointer.next;
        RandomListNode newHeadNode = pointer, newTailNode = pointer;
        pointer = pointer.next;
        boolean isSolveOldNode = true;
        while (pointer != null){
            if (isSolveOldNode){
                oldTailNode.next = pointer;
                oldTailNode = pointer;
            }else{
                newTailNode.next = pointer;
                newTailNode = pointer;
            }
            isSolveOldNode = !isSolveOldNode;
            pointer = pointer.next;
        }
        oldTailNode.next = null;
        newTailNode.next = null;
        // 返回复制链表的头结点
        return newHeadNode;
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