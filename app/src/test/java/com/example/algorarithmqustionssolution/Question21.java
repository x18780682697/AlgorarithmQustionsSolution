package com.example.algorarithmqustionssolution;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/19.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question21 {

    //方法：data1数组的顺序表示入栈的顺序。现在判断data2的这种出栈顺序是否正确
    public static boolean sequenseIsPop(int[] data1, int[] data2) {
        Stack<Integer> stack = new Stack<Integer>(); //这里需要用到辅助栈

        for (int i = 0, j = 0; i < data1.length; i++) {
            stack.push(data1[i]);

            while (stack.size() > 0 && stack.peek() == data2[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.size() == 0;
    }

}
