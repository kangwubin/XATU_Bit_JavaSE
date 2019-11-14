package LeetCodeNowCoder;

import java.util.Stack;

/**
 * Description:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串.
 * 注意：一般与括号有关的问题，就考虑栈；一定要画图演示.
 * 如果在main函数调用方法，此方法需要用static修饰；
 *
 * @author: KangWuBin
 * @Date: 2019/11/13
 * @Time: 22:30
 */
public class Solution {
    public boolean isValid(String s) {  //面试重点
        //创建存储字符的栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            //如果是左括号就入栈
            if (charAt == '(' || charAt == '[' || charAt == '{') {
                stack.push(charAt);
                continue;
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    //取栈顶元素，不删除
                    char top = stack.peek();
                    if (top == '(' && charAt == ')' || top == '[' && charAt == ']'
                            || top == '{' && charAt == '}') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            //左括号多
            return false;
        }
        return true;
    }

    public boolean isValid1(String s) {
        //创建存储字符的栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            //如果是左括号就入栈
            if (charAt == '(' || charAt == '[' || charAt == '{') {
                stack.push(charAt);
                continue;
            }
            //如果是右括号, 取出栈顶元素,取之前先判断栈是否为空
            if (stack.isEmpty()) {
                return false;
            }
            // 取栈顶元素,不删除
            char top = stack.pop();
            // 判断栈顶元素和当前元素是不是配对的
            if (top == '(' && charAt == ')') {
                continue;
            }
            if (top == '[' && charAt == ']') {
                continue;
            }
            if (top == '{' && charAt == '}') {
                continue;
            }
            return false;
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
