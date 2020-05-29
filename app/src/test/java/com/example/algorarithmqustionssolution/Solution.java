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
        if (root == null){
            return;
        }
        List<BinaryTreeNode> current = new ArrayList<>();
        List<BinaryTreeNode> childNodeList = new ArrayList<>();
        ArrayList<Integer> tmpResultList = new ArrayList<>();
        int flag = 1;
        current.add(root);
        while (current.size() != 0){
            BinaryTreeNode node = current.remove(current.size() - 1);
            tmpResultList.add(node.val);
            if (flag % 2 == 1){ // 奇数行的子节点从左到右存入，从右到左取出并打印
                if (node.left != null){
                    childNodeList.add(node.left);
                }
                if (node.right != null){
                    childNodeList.add(node.right);
                }
            }else{ // 偶数行的子节点从右到左存入，从左到右取出并打印
                if (node.right != null){
                    childNodeList.add(node.right);
                }
                if (node.left != null){
                    childNodeList.add(node.left);
                }
            }
            if (current.size() == 0){
                sResultList.add(tmpResultList);
                tmpResultList = new ArrayList<>();
                List<BinaryTreeNode> tmp = current;
                current = childNodeList;
                childNodeList = tmp;
                flag++;
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