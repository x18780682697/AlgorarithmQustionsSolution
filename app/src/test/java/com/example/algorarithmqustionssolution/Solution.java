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

    public static void print(BinaryTreeNode root) {

        if (root == null) {
            return;
        }


        List<BinaryTreeNode> current = new LinkedList<>();
        List<BinaryTreeNode> reverse = new LinkedList<>();
        int flag = 0;
        BinaryTreeNode node;
        current.add(root);
        ArrayList<Integer> tmpResultList = new ArrayList<>();

        while (current.size() > 0) {

            // 从最后一个开始取
            node = current.remove(current.size() - 1);

            tmpResultList.add(node.val);
            System.out.printf("%-3d", node.val);

            // 当前是从左往右打印的，那就按从左往右入栈
            if (flag == 0) {
                if (node.left != null) {
                    reverse.add(node.left);
                }

                if (node.right != null) {
                    reverse.add(node.right);
                }


            }
            // 当前是从右往左打印的，那就按从右往左入栈
            else {
                if (node.right != null) {
                    reverse.add(node.right);
                }

                if (node.left != null) {
                    reverse.add(node.left);
                }
            }

            if (current.size() == 0) {
                flag = 1 - flag;
                List<BinaryTreeNode> tmp = current;
                current = reverse;
                reverse = tmp;
                System.out.println();
                sResultList.add(tmpResultList);
                tmpResultList = new ArrayList<>();
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