package day2_191212;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/12
 * @Time: 21:13
 */
public class MainDrink {
    /*有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。
     *小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，
     *方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
     *然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
     *如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？*/
    public static int WaterMax(int n) {
        //注：此题易忽略细节---华为笔试题
       /* int num1 = 0;
        int bnum = 0;
        int bnum1 = 0;
        bnum1 = n / 3;
        n = n % 3;
        bnum = bnum1 + bnum;
        num1 = n + bnum1;
        while (num1 >= 3) {
            n = num1 % 3;
            bnum1 = num1 / 3;
            bnum = bnum1 + bnum;
            num1 = n + bnum1;
        }
        if (num1 == 2) {
            bnum++;
        }
        return bnum;*/
        //-----------------------------------------方式2-------------------------------------------
        int a = 0;//喝的汽水的数量
        if (n == 0) {
            return 0;
        }
        while (n > 1) {
            a = a + n / 3;
            n = n % 3 + n / 3;
            if (n == 2) {
                n = n + 1;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num != 0) {
                System.out.println(WaterMax(num));
            }
        }
    }
}
