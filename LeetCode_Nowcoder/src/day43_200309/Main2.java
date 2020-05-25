package day43_200309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description:输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,
 * 要求将其中所有的可能组合列出来
 * 输入：5 5
 * 输出：1 4<br/>2 3<br/>5
 * @author: KangWuBin
 * @Date: 2020/3/10
 * @Time: 0:40
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
    }
}
