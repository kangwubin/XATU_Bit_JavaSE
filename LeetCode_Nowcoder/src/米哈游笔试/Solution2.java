package 米哈游笔试;

import java.util.Stack;

/**
 * Description:移除无效的括号
 *
 * @author: KangWuBin
 * @Date: 2020/3/13
 * @Time: 19:35
 */
public class Solution2 {
    /**
     * @param s string字符串
     * @return string字符串
     */
    public String minRemove(String s) {
        // write code here
        Stack<Integer> index = new Stack<>();
        boolean[] invalidIndex = new boolean[s.length()];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                index.push(i);
                invalidIndex[i] = true;
            }
            if (s.charAt(i) == ')') {
                if (index.empty()) {
                    invalidIndex[i] = true;
                } else {
                    invalidIndex[index.pop()] = false;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndex[i]) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
