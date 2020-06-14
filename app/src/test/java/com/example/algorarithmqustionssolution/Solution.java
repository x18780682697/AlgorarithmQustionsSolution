package com.example.algorarithmqustionssolution;

@SuppressWarnings("unused")
public class Solution {

    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0){
            return 0;
        }
        return getNumberOfK(array, k);
    }

    /**
     * 题目：统计一个数字：在排序数组中出现的次数
     * @param data
     * @param k
     * @return
     */
    public static int getNumberOfK(int[] data, int k) {
        int cnt = 0;
        int startIndex = getTargetIndex(data, k, true);
        int endIndex = getTargetIndex(data, k, false);
        if (startIndex >= 0 && endIndex >= 0 && endIndex >= startIndex){
            cnt = endIndex - startIndex + 1;
        }
        return cnt;
    }

    /**
     * 用于获取k出现的开始位置和结束位置
     * @param data
     * @param k
     * @param isTryFindStart
     * @return
     */
    private static int getTargetIndex(int[] data, int k, boolean isTryFindStart) {
        int start = 0;
        int end = data.length-1;
        int mid;
        while (start <= end){
            mid = start + (end - start);
            if (data[mid] == k){
                // 核心逻辑
                // 根据是寻找开始索引还是结束索引
                // 选取判断规则
                if (isTryFindStart){
                    if (mid == 0 || data[mid-1] != k){
                        return mid;
                    }else{
                        end = mid-1;
                    }
                }else{
                    if (mid == data.length-1 || data[mid+1] != k){
                        return mid;
                    }else{
                        start = mid+1;
                    }
                }
            }else{
                boolean isAbove = data[mid] > k;
                if (isAbove){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }

        }
        return -1;
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