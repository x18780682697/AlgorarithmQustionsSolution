package com.example.algorarithmqustionssolution;

public class TestSome {

    public static String zipStr(String input){
        if (input == null){
            return null;
        }
        /* 使用StringBuilder提高字符串拼接性能 */
        StringBuilder result = new StringBuilder();
        // 将输入字符串转换为char数组以便后续处理
        char[] inputCharArray = input.toCharArray();
        char countingChar = inputCharArray[0];
        int where = 1, count = 1;
        while (where < inputCharArray.length){
            char thisChar = inputCharArray[where];
            if (thisChar == countingChar){ // 当前char和上正在计数的char相同
                count++;
            }else { // 未重复则存储上个char压缩结果，然后开始新的char的计数
                result.append(countingChar);
                if (count > 1){
                    result.append(count);
                }
                countingChar = thisChar;
                count = 1;
            }
            where++;
        }
        // 单独存储最后的1个或最后几个重复char的压缩结果
        result.append(countingChar);
        if (count > 1){
            result.append(count);
        }
        return result.toString();
    }

}
