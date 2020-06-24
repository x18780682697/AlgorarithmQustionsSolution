package com.example.algorarithmqustionssolution;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unused")
public class Solution {

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        return findNumbersWithSum(array, sum);
    }

    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得得它们的和正好是s。
     * 如果有多对数字的和等于s，输出任意一对即可。
     *
     * @param data
     * @param sum
     * @return
     */
    public static ArrayList<Integer> findNumbersWithSum(int[] data, int sum) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (data == null || data.length < 2){
            return resultList;
        }
        // 开始从头尾开始计算
        int left = 0;
        int right = data.length-1;
        while (left < right){
            int curSum = data[left]+data[right];
            if (curSum > sum){ // 如果大于所求值，则right左移
                right--;
            }else if (curSum <sum){ // 如果小于所求值，则left右移
                left++;
            }else{ // 相等则已经找到两个满足条件的值
                resultList.add(data[left]);
                resultList.add(data[right]);
                break;
            }
        }
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