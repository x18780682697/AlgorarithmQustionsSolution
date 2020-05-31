package com.example.algorarithmqustionssolution

import com.example.algorarithmqustionssolution.graph.ExampleGraph
import org.junit.Test

import org.junit.Assert.*

/**
 * 用于测试《剑指offer》上的算法解法
 */
class ExampleUnitTest {

    /**
     * 第22题 test
     */
    @Test
    fun test() {
        ExampleGraph.createAdjMatrix()?.apply {
            dfsFromFirstVertex()
            bfsFromFirstVertex()
        }
        ExampleGraph.createAdjList()?.apply {
            dfsFromFirstVertex()
            bfsFromFirstVertex()
        }
        assertEquals(true, true)
    }

//    /**
//     * 第4题
//     */
//    @Test
//    fun testQ4() {
//        // 重建二叉树
//        Question4.construct(ExampleBinaryTree.preOrderArray, ExampleBinaryTree.inOrderArray)
//            // 利用重建后的二叉树获取后序遍历的数组
//            .run {
//                BinaryTreeUtil.postOrderTraversal(this, ArrayList())
//            }
//            // 判定后序遍历的数组是不是预期的结果
//            .run {
//                assertArrayEquals(ExampleBinaryTree.postOrderArray, this?.toIntArray())
//            }
//    }

//    /**
//     * 第17题
//     */
//    @Test
//    fun testQ17() {
//        // 创建二叉树
//        ExampleBinaryTree.create().run {
//            assertEquals(true, Question17Fixed.HasSubtree(this, this))
//        }
//    }

//    /**
//     * 第18题
//     */
//    @Test
//    fun testQ18() {
//        // 暂无测试
//    }

//    /**
//     * 第22题 test
//     */
//    @Test
//    fun testQ22() {
//        // 暂无测试
//    }

}
