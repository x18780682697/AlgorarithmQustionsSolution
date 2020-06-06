package com.example.algorarithmqustionssolution;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/18.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question20 {

    public class MinStack {

        private Stack<Integer> stack = new Stack<Integer>();
        private Stack<Integer> minStack = new Stack<Integer>(); //辅助栈：栈顶永远保存stack中当前的最小的元素


        public void push(int data) {
            stack.push(data);  //直接往栈中添加数据

            //在辅助栈中需要做判断
            if (minStack.size() == 0 || data < minStack.peek()) {
                minStack.push(data);
            } else {
                minStack.add(minStack.peek());   //【核心代码】peek方法返回的是栈顶的元素
            }
        }

        public int pop() throws Exception {
            if (stack.size() == 0) {
                throw new Exception("栈中为空");
            }

            int data = stack.pop();
            minStack.pop();  //核心代码
            return data;
        }

        public int min() throws Exception {
            if (minStack.size() == 0) {
                throw new Exception("栈中空了");
            }
            return minStack.peek();
        }
    }

}
