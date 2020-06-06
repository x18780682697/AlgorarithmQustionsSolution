package com.example.algorarithmqustionssolution;

import java.util.Stack;

@SuppressWarnings("unused")
public class Solution {

    MinStack mMinStack = new MinStack();

    public void push(int node) {
        mMinStack.push(node);
    }

    public void pop() {
        try {
            mMinStack.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int top() {
        try {
            return mMinStack.peek();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int min() throws Exception {
        return mMinStack.min();
    }

    public class MinStack {

        private Stack<Integer> stack = new Stack<Integer>();
        private Stack<Integer> minStack = new Stack<Integer>(); //辅助栈：栈顶永远保存stack中当前的最小的元素


        public void push(int data) {
            stack.push(data);
            if (minStack.size() == 0 || data < minStack.peek()){
                minStack.push(data);
            }else{
                minStack.push(minStack.peek());
            }
        }

        public int pop() throws Exception {
            if (stack.size() == 0){
                throw new RuntimeException("no more");
            }
            minStack.pop();
            return stack.pop();
        }

        public int min() throws Exception {
            if (stack.size() == 0){
                throw new RuntimeException("no more");
            }
            return minStack.peek();
        }

        public int peek() throws Exception {
            if (stack.size() == 0){
                throw new RuntimeException("no more");
            }
            return stack.peek();
        }
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