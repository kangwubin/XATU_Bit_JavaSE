package day1_191211;


import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/11
 * @Time: 17:16
 */
public class TestReverse {
    //判断回文串的方法
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String A = in.nextLine();
            String B = in.nextLine();
            int count = 0;
            for (int i = 0; i < A.length(); i++) {
                StringBuilder sb = new StringBuilder(A);
                sb.insert(i, B);
                if (isPalindrome(sb.toString())) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
