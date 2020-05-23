package com.example.algorarithmqustionssolution

import com.example.algorarithmqustionssolution.binarytree.BinaryTreeUtil
import com.example.algorarithmqustionssolution.binarytree.ExampleBinaryTree
import org.junit.Test

import org.junit.Assert.*

/**
 * 用于测试《剑指offer》上的算法解法
 */
class ExampleUnitTest {

    /**
     *
     */
    @Test
    fun testQ4() {
        // 重建二叉树
        Question4.construct(ExampleBinaryTree.preOrderArray, ExampleBinaryTree.inOrderArray)
            // 利用重建后的二叉树获取后序遍历的数组
            .run {
                BinaryTreeUtil.postOrderTraversal(this, ArrayList())
            }
            // 判定后序遍历的数组是不是预期的结果
            .run {
                assertArrayEquals(ExampleBinaryTree.postOrderArray, this?.toIntArray())
            }
    }

}
