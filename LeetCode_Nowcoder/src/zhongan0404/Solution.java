package zhongan0404;

import java.util.*;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/4/4
 * @Time: 21:07
 */
public class Solution {
    /**
     * @param commands string字符串一维数组 状态机指令，由“0”、“1”组成
     * @return bool布尔型
     */
    public boolean handleCommands(String[] commands) {
        // write code here
        String Q1 = null;
        String Q2 = "合法";
        String Q3 = "不合法";
        if (commands.equals("1") ) {
            Q2 = Q1;
            Q2 = Q2;
        }
        if (commands.equals("0")) {
            Q3 = Q2;
            Q1 = Q1;
        }
        if (commands.equals("0") || commands.equals("1")) {
            Q2 = Q3;
        }
        if (commands == null || commands.equals("")) {
            Q1 = Q1;
        }
        return true;
    }
}
