package com.example.algorarithmqustionssolution;

/**
 * 28-数组中出现次数超过一半的数字
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/26.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question28 {

    /**
     * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
     *
     * @param numbers 输入数组
     * @return 找到的数字
     */
    public static int moreThanHalfNum(int[] numbers) {

        // 输入校验
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("array length must large than 0");
        }

        // 用于记录出现次数大于数组一半的数
        int result = numbers[0];
        // 于当前记录的数不同的数的个数
        int count = 1;
        // 从第二个数开始向后找
        for (int i = 1; i < numbers.length; i++) {
            // 如果记数为0
            if (count == 0) {
                // 重新记录一个数，假设它是出现次数大于数组一半的
                result = numbers[i];
                // 记录统计值
                count = 1;
            }
            // 如果记录的值与统计值相等，记数值增加
            else if (result == numbers[i]) {
                count++;
            }
            // 如果不相同就减少，相互抵消
            else {
                count--;
            }
        }

        // 最后的result可能是出现次数大于数组一半长度的值
        // 统计result的出现次数
        count = 0;
        for (int number : numbers) {
            if (result == number) {
                count++;
            }
        }

        // 如果出现次数大于数组的一半就返回对应的值
        if (count > numbers.length / 2) {
            return result;
        }
        // 否则输入异常
        else {
            throw new IllegalArgumentException("invalid input");
        }
    }

}
