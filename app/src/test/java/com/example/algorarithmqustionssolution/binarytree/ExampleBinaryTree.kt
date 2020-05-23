@file:Suppress("unused")

package com.example.algorarithmqustionssolution.binarytree


import com.example.algorarithmqustionssolution.Solution.*

/**
 * 示例二叉树图形表示详见以下链接：
 * https://blog.csdn.net/zlp1992/article/details/51406067
 *
 */
object ExampleBinaryTree {

    /**
     * 前序遍历结果数组表示
     */
    val preOrderArray = intArrayOf(6,2,0,1,4,5,8,9)

    /**
     * 中序遍历结果数组表示
     */
    val inOrderArray = intArrayOf(0,1,2,4,5,6,8,9)

    /**
     * 后序遍历结果数组表示
     */
    val postOrderArray = intArrayOf(1,0,5,4,2,9,8,6)

    fun create(): BinaryTreeNode?{
        return arrayOf(6, 2, 0, null, 1, null, null, 4, null, 5, null, null, 8, null, 9, null, null)
            .run {
                BinaryTreeUtil.createByPreOrderArray(this, iterator())
            }
//            .apply {
//                BinaryTreeUtil.postOrderTraversal(this)
//            }
    }

}