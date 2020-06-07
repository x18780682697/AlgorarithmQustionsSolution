package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("unused")
public class Solution {

    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0){
            return resultList;
        }
        if (num.length < size){
            return resultList;
        }
        List<Integer> dataList = new ArrayList<>();
        for (int value : num) {
            dataList.add(value);
        }
        resultList.addAll(maxInWindowsCore(dataList, size));
        return resultList;
    }

    private static List<Integer> maxInWindowsCore(List<Integer> data, int size) {
        List<Integer> resultList = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        // 根据size大小填充滑动窗口
        for (int i=0; i<size; i++){
            while (!queue.isEmpty() && data.get(i) >= data.get(queue.getLast())){
                queue.removeLast();
            }
            queue.add(i);
        }
        // 滑动窗口逐步从左至右滑动
        for (int i=size; i<data.size(); i++){
            resultList.add(data.get(queue.getFirst()));
            while (!queue.isEmpty() && data.get(i) >= data.get(queue.getLast())){
                queue.removeLast();
            }
            if (!queue.isEmpty() && queue.getFirst() <= i-size){
                queue.removeFirst();
            }
            queue.add(i);
        }
        // 额外加上最后1个窗口的最大元素
        resultList.add(data.get(queue.getFirst()));
        return resultList;
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