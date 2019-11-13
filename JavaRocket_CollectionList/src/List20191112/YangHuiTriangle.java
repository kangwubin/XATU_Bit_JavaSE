package List20191112;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:杨辉三角：给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 1.第一行是固定的, 就只有一个 1
 * 2.第二行也是固定的, 就只有两个 1
 * 3.任意一行, 开头和结尾也都是 1
 * 4.第 i 行, 有 i 列
 * 5.第 i 行的第 j 列, 这个数字是根据 i - 1, j - 1列和 j 列相加
 *
 * @author: KangWuBin
 * @Date: 2019/11/12
 * @Time: 15:22
 */
public class YangHuiTriangle {
    public List<List<Integer>> generate1(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        //存放总行数的集合
        List<List<Integer>> result = new ArrayList<>();

        // 1. 先把第一行插入进去
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }
        // 2. 再把第二行插入进去
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        //3.当行数大于2的时候,若知道当前行的内容, 需要先知道上一行，row 本来是 从 1 开始计数的.
        // row - 1 是把从 1 开始计数的数字转成下标，即从0开始.row - 1 - 1 取到上一行的下标
        for (int row = 3; row <= numRows; row++) {
            //当前行的前一行
            List<Integer> prevLine = result.get(row - 1 - 1);
            //当前行的List
            List<Integer> curLine = new ArrayList<>();
            //给当前行添加元素，当前行的第0列和最后一列一定是1
            curLine.add(1);
            for (int col = 1; col < row - 1; col++) {
                curLine.add(prevLine.get(col - 1) + prevLine.get(col));
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }

    public static void main(String[] args) {
        YangHuiTriangle y = new YangHuiTriangle();
        List<List<Integer>> integerList = y.generate1(5);
        System.out.println(integerList);
    }
}
