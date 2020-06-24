package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1-二维数组查找
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/1.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question42 {

    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得得它们的和正好是s。
     * 如果有多对数字的和等于s，输出任意一对即可。
     *
     * @param data
     * @param sum
     * @return
     */
    public static List<Integer> findNumbersWithSum(int[] data, int sum) {
        List<Integer> result = new ArrayList<>(2);

        if (data == null || data.length < 2) {
            return result;
        }

        int ahead = data.length - 1;
        int behind = 0;
        long curSum; // 统计和，取long是防止结果溢出

        while (behind < ahead) {
            curSum = data[behind] + data[ahead];

            if (curSum == sum) {
                result.add(data[behind]);
                result.add(data[ahead]);
                break;
            } else if (curSum < sum) {
                behind++;
            } else {
                ahead--;
            }
        }

        return result;
    }

}
