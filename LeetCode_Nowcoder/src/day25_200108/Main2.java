package day25_200108;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/9
 * @Time: 16:34
 */
public class Main2 {
    /* 1.中文大写金额数字前应标明“人民币”字样。
     * 中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
     * 2.中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。
     * 在”角“和”分“后面不写”整字。（30分）
     * 3.阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，
     * 中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。
     * 输入：151121.15；输出：人民币拾伍万壹仟壹佰贰拾壹元壹角伍分；*/
    static String[] chinese = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String money = scanner.nextLine();
            String[] moneys = money.split("\\.");
        }
    }
}
