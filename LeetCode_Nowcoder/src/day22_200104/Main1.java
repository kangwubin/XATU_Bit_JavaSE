package day22_200104;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description:
 * 小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；
 * 如果不是，那么告诉她缺了多少珠子；
 * 为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。
 * 例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了全部她想要的珠子，还多了8颗不需要的珠子；
 * ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
 * 输入：每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。
 * 输出：如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。
 * 其间以1个空格分隔。
 *
 * @author: KangWuBin
 * @Date: 2020/1/3
 * @Time: 21:22
 */
public class Main1 {
    /* 输入：ppRYYGrrYBR2258   YrR8RrY；
     * 输出 ：Yes 8*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //str1--摊主的串；str2--小红想要的串
            String str1 = scanner.next();
            String str2 = scanner.next();
            ArrayList<Character> list = new ArrayList<>();
            //将摊主的串存入集合
            for (int i = 0; i < str1.length(); i++) {
                char ch = str1.charAt(i);
                list.add(ch);
            }
            int count = 0;
            //遍历小红想要的珠子
            for (int i = 0; i < str2.length(); i++) {
                char ch2 = str2.charAt(i);
                //遍历集合中的元素
                for (int j = 0; j < list.size(); j++) {
                    //如果小红想要的珠子在集中有，就将有的珠子从集合中删除，同时让count++；
                    if (ch2 == list.get(j)) {
                        list.remove(j);
                        count++;
                        break;
                    }
                }
            }
            if (count == str2.length()) {
                System.out.println("YES" + " " + (str1.length() - count));
            } else {
                System.out.println("No" + " " + (str2.length() - count));
            }
        }
    }
}
