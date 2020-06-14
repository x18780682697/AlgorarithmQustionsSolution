package com.example.algorarithmqustionssolution;

/**
 * 40-数组中只出现一次的数字
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/38.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question40 {

    public static int[] findNumbersAppearanceOnce(int[] data) {
        int[] result = {0, 0};

        if (data == null || data.length < 2) {
            return result;
        }

        int xor = 0;
        for (int i : data) {
            xor ^= i;
        }

        int indexOf1 = findFirstBit1(xor);

        for (int i : data) {
            if (isBit1(i, indexOf1)) {
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }

        return result;
    }

    private static int findFirstBit1(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
            num >>>= 1;
            index++;
        }

        return index;
    }

    private static boolean isBit1(int num, int indexBit) {
        num >>>= indexBit;
        return (num & 1) == 1;
    }

}
