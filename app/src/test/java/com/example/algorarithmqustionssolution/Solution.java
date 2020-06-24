package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unused")
public class Solution {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        return findContinuousSequence(sum);
    }

    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3){
            return result;
        }
        int left = 1;
        int right = 2;
        int curSum = left+right;
        int middle = (1+sum)/2;
        while (left < middle){
            // 寻找到满足条件的序列
            if (curSum == sum){
                ArrayList<Integer> childResult = new ArrayList<>();
               for (int i=left; i<=right; i++){
                   childResult.add(i);
               }
               result.add(childResult);
            }
            // 向右缩小滑动窗口大小
            while (curSum > sum && left < middle){
                curSum -= left;
                left++;
                // 寻找到满足条件的序列
                if (curSum == sum){
                    ArrayList<Integer> childResult = new ArrayList<>();
                    for (int i=left; i<=right; i++){
                        childResult.add(i);
                    }
                    result.add(childResult);
                }
            }
            // 向右增大滑动窗口大小
            right++;
            curSum += right;
        }
        return result;
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