package com.example.algorarithmqustionssolution;

import java.util.Stack;

/**
 * 删除链表中重复的结点
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/55.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question29 {

    /**
     * 题目： 输入n个整数，找出其中最小的k个数。
     * 【第一种解法】
     * @param input  输入数组
     * @param output 输出数组
     */
    public static void getLeastNumbers(int[] input, int[] output) {

        if (input == null || output == null || output.length <= 0 || input.length < output.length) {
            throw new IllegalArgumentException("Invalid args");
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        int target = output.length - 1;

        while (index != target) {
            if (index < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(input, start, end);
        }

        System.arraycopy(input, 0, output, 0, output.length);
    }

    /**
     * 分区算法
     *
     * @param input 输入数组
     * @param start 开始下标
     * @param end   结束下标
     * @return 分区位置
     */
    private static int partition(int[] input, int start, int end) {
        int tmp = input[start];

        while (start < end) {
            while (start < end && input[end] >= tmp) {
                end--;
            }
            input[start] = input[end];

            while (start < end && input[start] <= tmp) {
                start++;
            }
            input[end] = input[start];
        }

        input[start] = tmp;
        return start;
    }

}
