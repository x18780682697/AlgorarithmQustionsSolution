package com.example.algorarithmqustionssolution;

/**
 * 13-调整数组顺序使奇数位于偶数前面
 * （参考Solution中的方法给奇数和偶数排序后，牛客网才能AC）
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/11.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question13 {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
     *
     * @param arr 输入的数组
     */
    public static void reorderOddEven(int[] arr) {
        // 对于输入的数组为空，或者长度小于2的只接返回
        if (arr == null || arr.length < 2) {
            return;
        }

        // 从左向右记录偶数的位置
        int start = 0;
        // 从右向左记录奇数的位置
        int end = arr.length - 1;
        // 开始调整奇数和偶数的位置
        while (start < end) {
            // 找偶数
            while (start < end && arr[start] % 2 != 0) {
                start++;
            }
            // 找奇数
            while (start < end && arr[end] % 2 == 0) {
                end--;
            }

            // 找到后就将奇数和偶数交换位置
            // 对于start=end的情况，交换不会产生什么影响
            // 所以将if判断省去了
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

}
