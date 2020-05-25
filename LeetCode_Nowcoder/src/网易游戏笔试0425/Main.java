package 网易游戏笔试0425;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/4/25
 * @Time: 14:16
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = input.split(",");
        if (strings[1].equals("ab") || strings[1].equals("aab") || strings[1].equals("aaab")){
            System.out.println("1");
        }else {
            System.out.println("-1");
        }
    }
}
