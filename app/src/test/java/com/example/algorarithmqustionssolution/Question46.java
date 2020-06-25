package com.example.algorarithmqustionssolution;

import java.util.LinkedList;
import java.util.List;

/**
 * 46-孩子们的游戏-圆圈中最后剩下的数(约瑟夫环)
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/45.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question46 {

    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        // 要删除元素的位置
        int idx = 0;

        while (list.size() > 1) {

            // 只要移动m-1次就可以移动到下一个要删除的元素上
            for (int i = 1; i < m; i++) {
                idx = (idx + 1) % list.size();
            }

            list.remove(idx);
        }

        return list.get(0);
    }

}
