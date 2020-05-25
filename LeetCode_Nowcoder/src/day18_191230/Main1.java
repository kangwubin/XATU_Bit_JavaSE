package day18_191230;

import java.util.Scanner;

/**
 * Description:一个DNA序列由A/C/G/T四个字母的排列组合组成。
 * G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
 * 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 *
 * @author: KangWuBin
 * @Date: 2019/12/30
 * @Time: 9:40
 */
public class Main1 {
    //返回一个字符串的GC比例
    private static double func(String string) {
        double ratio = 0;
        double count = 0;   //计算序列中G和C两个字母的总的出现次数；
        for (char ch : string.toCharArray()) {
            if (ch == 'G' || ch == 'C') {
                count++;
            }
        }
        ratio = count / string.length();    //计算G和C的比例；
        return ratio;
    }

    /* 输入： 输入一个string型基因序列，和int型子串的长度；
     * 输出：找出GC比例最高的子串,如果有多个输出第一个的子串*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String strInput = scanner.nextLine();
            int inputN = scanner.nextInt();
            String maxStr = "";         //记录比例最高的字符串
            double maxRatio = 0;       //记录目前出现的最高比例
            for (int i = 0; i < strInput.length() - inputN + 1; i++) {
                String str = strInput.substring(i, i + inputN);
                if (func(str) > maxRatio) {
                    maxStr = str;
                    maxRatio = func(str);
                }
            }
            System.out.println(maxStr);
        }
    }
}
