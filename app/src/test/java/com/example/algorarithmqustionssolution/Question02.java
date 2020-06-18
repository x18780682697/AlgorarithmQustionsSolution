package com.example.algorarithmqustionssolution;

import java.util.Stack;

/**
 * 02-替换空格
 * （目前使用暴力解法，lrh1993的解法可以不用额外空间）
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/2.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question02 {

    public String replaceSpace(StringBuffer str) {
        if (str == null){
            return null;
        }
        return str.toString().replace(" ", "%20");
    }

}
