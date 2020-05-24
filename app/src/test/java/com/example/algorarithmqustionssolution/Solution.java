package com.example.algorarithmqustionssolution;

@SuppressWarnings("unused")
public class Solution {

    /**
     * 寻找相同节点并比较结构是否相同
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null){
            return false;
        }
        if (root1 == null){
            return false;
        }
        boolean hasSubTree = false;
        if (root1.val == root2.val){
            hasSubTree = hasSameStructure(root1, root2);
        }
        if (!hasSubTree){
            hasSubTree = HasSubtree(root1.left, root2);
        }
        if (!hasSubTree){
            hasSubTree = HasSubtree(root1.right, root2);
        }
        return hasSubTree;
    }

    private boolean hasSameStructure(TreeNode root1, TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        return root1.val == root2.val && hasSameStructure(root1.left, root2.left)
                && hasSameStructure(root1.right, root2.right);
    }

    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
    }

    /**
     * TreeNode和BinaryTreeNode之间的转换工具
     */
    public static class NodeTranslateUtil {
        /**
         * 转换为TreeNode
         */
        public static TreeNode toTreeNode(BinaryTreeNode node){
            TreeNode treeNode = null;
            if (node == null){
                return null;
            }else{
                treeNode = new TreeNode(node.value);
                treeNode.left = toTreeNode(node.left);
                treeNode.right = toTreeNode(node.right);
            }
            return treeNode;
        }

        /**
         * 转换为BinaryTreeNode
         */
        public static BinaryTreeNode toBinaryTreeNode(TreeNode node){
            BinaryTreeNode binaryTreeNode = null;
            if (node == null){
                return null;
            }else{
                binaryTreeNode = new BinaryTreeNode();
                binaryTreeNode.value = node.val;
                binaryTreeNode.left = toBinaryTreeNode(node.left);
                binaryTreeNode.right = toBinaryTreeNode(node.right);
            }
            return binaryTreeNode;
        }
    }

}

/**
 * 牛客网二叉树定义
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}