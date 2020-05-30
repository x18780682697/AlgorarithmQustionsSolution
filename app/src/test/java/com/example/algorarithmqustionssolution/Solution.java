package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class Solution {

    public static ArrayList<ArrayList<Integer>> sResultList = new ArrayList<>();

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        sResultList.clear();
        print(NodeTranslateUtil.toBinaryTreeNode(pRoot));
        return sResultList;
    }

    /**
     * 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印一行。
     * @param root
     */
    public static void print(BinaryTreeNode root) {
        if (root == null){
            return;
        }
        List<BinaryTreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        int currentCnt = 1;
        int nextCnt = 0;
        ArrayList<Integer> tmpList = new ArrayList<>();
        while (nodeList.size() > 0){
            BinaryTreeNode node = nodeList.remove(0);
            tmpList.add(node.val);
            currentCnt--;
            if (node.left != null){
                nodeList.add(node.left);
                nextCnt++;
            }
            if (node.right != null){
                nodeList.add(node.right);
                nextCnt++;
            }
            if (currentCnt == 0){
                sResultList.add(tmpList);
                tmpList = new ArrayList<>();
                currentCnt = nextCnt;
                nextCnt = 0;
            }
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