package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unused")
public class Solution {

    public void reOrderArray(int [] array) {
        if (array == null || array.length <= 1){
            return;
        }
        reorderOddEven(array);
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
     *
     * @param arr 输入的数组
     */
    public static void reorderOddEven(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while (start < end){
            // 从左往右找偶数，搬到数组后半段
            while (start < end && arr[start]%2 == 1){
                start++;
            }
            // 从右往左找奇数，搬到数组前半段
            while (start < end && arr[end]%2 == 0){
                end--;
            }
            if (start < end){
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
            }
        }
        int oddNumEndIdx = arr[end]%2==1 ? end : end-1;
        List<Integer> tmpList = new ArrayList<>();

        // 给奇数排序
        tmpList.clear();
        for (int i=0; i<=oddNumEndIdx; i++){
            tmpList.add(arr[i]);
        }
        tmpList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i=0; i<tmpList.size(); i++){
            arr[i] = tmpList.get(i);
        }

        // 给偶数排序
        tmpList.clear();
        for (int i=oddNumEndIdx+1; i<=arr.length-1; i++){
            tmpList.add(arr[i]);
        }
        tmpList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i=0; i<tmpList.size(); i++){
            arr[oddNumEndIdx+1+i] = tmpList.get(i);
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