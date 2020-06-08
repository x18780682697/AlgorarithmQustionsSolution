package com.example.algorarithmqustionssolution;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 34-第一个只出现一次的字符
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/34.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question34 {

    public static char firstNotRepeatingChar(String s) {
        if (s == null || s.length() < 1) {
            throw new IllegalArgumentException("Arg should not be null or empty");
        }

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -2);
            } else {
                map.put(c, i);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        // 记录只出现一次的字符的索引
        int idx = Integer.MAX_VALUE;
        // 记录只出现一次的字符
        char result = '\0';

        // 找最小索引对应的字符
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() >= 0 && entry.getValue() < idx) {
                idx = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

}
